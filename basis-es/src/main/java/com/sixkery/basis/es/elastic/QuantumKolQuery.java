package com.sixkery.basis.es.elastic;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.google.common.collect.Lists;
import com.sixkery.basis.es.domain.esentity.QuantumKolEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author sixkery
 * @since 2023/9/4
 */
@Repository
@Slf4j
public class QuantumKolQuery {

    @Resource
    private ElasticsearchClient pgClient;


    public List<QuantumKolEntity> kolUserQuery(String indexName, List<Query> queries, List<Query> mustNotQueries) {
        return kolUserQuery(indexName, queries, mustNotQueries, 100);
    }


    public List<QuantumKolEntity> kolUserQuery(String indexName, List<Query> queries, List<Query> mustNotQueries, Integer size) {

        try {
            SearchRequest searchRequest = SearchRequest.of(s -> s
                    .index(indexName)
                    .query(q -> q.bool(b -> b.must(queries).mustNot(mustNotQueries)))
                    .trackTotalHits(t -> t.enabled(true))
                    .source(r -> r.fetch(true))
                    .size(size)
            );

            log.info("es user dsl : {}", searchRequest.toString());
            SearchResponse<QuantumKolEntity> search = pgClient.search(searchRequest, QuantumKolEntity.class);
            List<QuantumKolEntity> result = Lists.newArrayList();
            for (Hit<QuantumKolEntity> obj : search.hits().hits()) {
                QuantumKolEntity user = obj.source();
                result.add(user);
            }
            return result;

        } catch (IOException e) {
            log.error("es user query error", e);
            return Collections.emptyList();
        }
    }


}

package com.home.boot.boot2.model.emb;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QorderId is a Querydsl query type for orderId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QorderId extends BeanPath<orderId> {

    private static final long serialVersionUID = 2035695656L;

    public static final QorderId orderId = new QorderId("orderId");

    public final DateTimePath<java.time.LocalDateTime> dateTime = createDateTime("dateTime", java.time.LocalDateTime.class);

    public final StringPath name = createString("name");

    public QorderId(String variable) {
        super(orderId.class, forVariable(variable));
    }

    public QorderId(Path<? extends orderId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QorderId(PathMetadata metadata) {
        super(orderId.class, metadata);
    }

}


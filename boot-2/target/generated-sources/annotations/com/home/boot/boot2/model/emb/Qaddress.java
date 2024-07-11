package com.home.boot.boot2.model.emb;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qaddress is a Querydsl query type for address
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class Qaddress extends BeanPath<address> {

    private static final long serialVersionUID = 2095114003L;

    public static final Qaddress address = new Qaddress("address");

    public final StringPath region = createString("region");

    public final StringPath street = createString("street");

    public final StringPath town = createString("town");

    public Qaddress(String variable) {
        super(address.class, forVariable(variable));
    }

    public Qaddress(Path<? extends address> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qaddress(PathMetadata metadata) {
        super(address.class, metadata);
    }

}


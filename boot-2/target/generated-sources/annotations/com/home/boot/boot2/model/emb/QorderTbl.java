package com.home.boot.boot2.model.emb;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QorderTbl is a Querydsl query type for orderTbl
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QorderTbl extends EntityPathBase<orderTbl> {

    private static final long serialVersionUID = -1317933487L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QorderTbl orderTbl = new QorderTbl("orderTbl");

    public final Qaddress address;

    public final QorderId orderId;

    public final StringPath otherField = createString("otherField");

    public QorderTbl(String variable) {
        this(orderTbl.class, forVariable(variable), INITS);
    }

    public QorderTbl(Path<? extends orderTbl> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QorderTbl(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QorderTbl(PathMetadata metadata, PathInits inits) {
        this(orderTbl.class, metadata, inits);
    }

    public QorderTbl(Class<? extends orderTbl> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new Qaddress(forProperty("address")) : null;
        this.orderId = inits.isInitialized("orderId") ? new QorderId(forProperty("orderId")) : null;
    }

}


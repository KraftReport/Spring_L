package com.home.boot.boot2.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResources is a Querydsl query type for Resources
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResources extends EntityPathBase<Resources> {

    private static final long serialVersionUID = -3349736L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResources resources = new QResources("resources");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QLecture lecture;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> size = createNumber("size", Integer.class);

    public final StringPath url = createString("url");

    public QResources(String variable) {
        this(Resources.class, forVariable(variable), INITS);
    }

    public QResources(Path<? extends Resources> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResources(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResources(PathMetadata metadata, PathInits inits) {
        this(Resources.class, metadata, inits);
    }

    public QResources(Class<? extends Resources> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lecture = inits.isInitialized("lecture") ? new QLecture(forProperty("lecture"), inits.get("lecture")) : null;
    }

}


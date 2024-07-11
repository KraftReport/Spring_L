package com.home.boot.boot2.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVideo is a Querydsl query type for Video
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVideo extends EntityPathBase<Video> {

    private static final long serialVersionUID = 395750126L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVideo video = new QVideo("video");

    public final QResources _super;

    //inherited
    public final NumberPath<Integer> id;

    // inherited
    public final QLecture lecture;

    public final NumberPath<Integer> length = createNumber("length", Integer.class);

    //inherited
    public final StringPath name;

    //inherited
    public final NumberPath<Integer> size;

    //inherited
    public final StringPath url;

    public QVideo(String variable) {
        this(Video.class, forVariable(variable), INITS);
    }

    public QVideo(Path<? extends Video> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVideo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVideo(PathMetadata metadata, PathInits inits) {
        this(Video.class, metadata, inits);
    }

    public QVideo(Class<? extends Video> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QResources(type, metadata, inits);
        this.id = _super.id;
        this.lecture = _super.lecture;
        this.name = _super.name;
        this.size = _super.size;
        this.url = _super.url;
    }

}


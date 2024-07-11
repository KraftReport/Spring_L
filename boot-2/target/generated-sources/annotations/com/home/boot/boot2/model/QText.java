package com.home.boot.boot2.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QText is a Querydsl query type for Text
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QText extends EntityPathBase<Text> {

    private static final long serialVersionUID = -541485990L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QText text = new QText("text");

    public final QResources _super;

    public final StringPath content = createString("content");

    //inherited
    public final NumberPath<Integer> id;

    // inherited
    public final QLecture lecture;

    //inherited
    public final StringPath name;

    //inherited
    public final NumberPath<Integer> size;

    //inherited
    public final StringPath url;

    public QText(String variable) {
        this(Text.class, forVariable(variable), INITS);
    }

    public QText(Path<? extends Text> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QText(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QText(PathMetadata metadata, PathInits inits) {
        this(Text.class, metadata, inits);
    }

    public QText(Class<? extends Text> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QResources(type, metadata, inits);
        this.id = _super.id;
        this.lecture = _super.lecture;
        this.name = _super.name;
        this.size = _super.size;
        this.url = _super.url;
    }

}


package com.home.boot.boot2.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSession is a Querydsl query type for Session
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSession extends EntityPathBase<Session> {

    private static final long serialVersionUID = -404010935L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSession session = new QSession("session");

    public final QBase _super = new QBase(this);

    public final QCourse course;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Integer> id = _super.id;

    public final ListPath<Lecture, QLecture> lectures = this.<Lecture, QLecture>createList("lectures", Lecture.class, QLecture.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> sessionOrder = createNumber("sessionOrder", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QSession(String variable) {
        this(Session.class, forVariable(variable), INITS);
    }

    public QSession(Path<? extends Session> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSession(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSession(PathMetadata metadata, PathInits inits) {
        this(Session.class, metadata, inits);
    }

    public QSession(Class<? extends Session> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new QCourse(forProperty("course")) : null;
    }

}


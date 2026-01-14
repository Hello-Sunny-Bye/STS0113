package com.korea.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 187651677L;

    public static final QMember member = new QMember("member1");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath detailAddress = createString("detailAddress");

    public final StringPath etc = createString("etc");

    public final StringPath extraAddress = createString("extraAddress");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath jibunAddress = createString("jibunAddress");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath postcode = createString("postcode");

    public final StringPath roadAddress = createString("roadAddress");

    public final StringPath role = createString("role");

    public final StringPath tel = createString("tel");

    public final StringPath username = createString("username");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}


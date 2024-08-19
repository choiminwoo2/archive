package org.zerock.servletmvc.auth.service;

import java.sql.SQLException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.servletmvc.auth.dao.MemberDAO;
import org.zerock.servletmvc.auth.domain.MemberEntity;
import org.zerock.servletmvc.auth.dto.MemberDTO;
import org.zerock.servletmvc.util.MapperUtil;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {

        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws SQLException {

        MemberEntity entity = dao.getWithPassword(mid, mpw);
        MemberDTO dto = MemberDTO.builder()
            .mid(entity.getMid())
            .mname(entity.getMname())
            .mpw(entity.getMpw())
            .uuid(entity.getUuid())
            .build();

        return dto;

    }

    public void updateUuid(String mid, String uuid) throws Exception {

        dao.updateUuid(mid, uuid);
    }

    public MemberDTO findByUuid(String uuid) throws Exception {

        MemberEntity entity = dao.selectUUID(uuid);
        MemberDTO memberDTO = MemberDTO.builder()
            .mid(entity.getMid())
            .mname(entity.getMname())
            .mpw(entity.getMpw())
            .uuid(entity.getUuid())
            .build();
        return memberDTO;
    }
}

package com.bitcamp.testproject.vo;

import java.sql.Date;
import java.util.List;

public class Party {

  private int no;
  private int locationNo;
  private String title;
  private boolean active;
  private String content;
  private Date createdDate;
  private int headCount;
  private Date partyTime;
  private Date partydate;

  // 첨부파일 정보를 저장할 필드
  private List<PartyAttachedFile> partyAttachedFiles;

  // 댓글을 저장할 필드
  private List<PartyComment> partyComment;



}

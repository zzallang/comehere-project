package com.bitcamp.testproject.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bitcamp.testproject.service.BoardService;
import com.bitcamp.testproject.vo.AttachedFile;
import com.bitcamp.testproject.vo.Board;
import com.bitcamp.testproject.vo.Criteria;
import com.bitcamp.testproject.vo.PageMaker;

@Controller
@RequestMapping("/board/")
public class BoardController {

  @Autowired
  ServletContext sc;
  @Autowired
  BoardService boardService;

  // InternalResourceViewResolver 사용 후:
  //  @GetMapping("form")
  //  public void form() throws Exception {
  //  }

  //  @PostMapping("add") 
  //  public String add(
  //      Board board,
  //      MultipartFile[] files,
  //      HttpSession session) throws Exception {
  //
  //    board.setAttachedFiles(saveAttachedFiles(files));
  //    board.setWriter((Member) session.getAttribute("loginMember"));
  //
  //    boardService.add(board);
  //    return "redirect:list";
  //  }
  //
  //  private List<BoardAttachedFile> saveAttachedFiles(Part[] files)
  //      throws IOException, ServletException {
  //    List<BoardAttachedFile> attachedFiles = new ArrayList<>();
  //    String dirPath = sc.getRealPath("/board/files");
  //
  //    for (Part part : files) {
  //      if (part.getSize() == 0) {
  //        continue;
  //      }
  //
  //      String filename = UUID.randomUUID().toString();
  //      part.write(dirPath + "/" + filename);
  //      attachedFiles.add(new BoardAttachedFile(filename));
  //    }
  //    return attachedFiles;
  //  }
  //
  //  private List<BoardAttachedFile> saveAttachedFiles(MultipartFile[] files)
  //      throws IOException, ServletException {
  //    List<BoardAttachedFile> attachedFiles = new ArrayList<>();
  //    String dirPath = sc.getRealPath("/board/files");
  //
  //    for (MultipartFile part : files) {
  //      if (part.isEmpty()) {
  //        continue;
  //      }
  //
  //      String filename = UUID.randomUUID().toString();
  //      part.transferTo(new File(dirPath + "/" + filename));
  //      attachedFiles.add(new BoardAttachedFile(filename));
  //    }
  //    return attachedFiles;
  //  }
  //
  //  @GetMapping("list")
  //  public void list(Model model) throws Exception {
  //    model.addAttribute("boards", boardService.list());
  //  }
  //
  //  @GetMapping("detail")
  //  public Map detail(int no) throws Exception {
  //    Board board = boardService.get(no);
  //    if (board == null) {
  //      throw new Exception("해당 번호의 게시글이 없습니다!");
  //    }
  //
  //    Map map = new HashMap();
  //    map.put("board", board);
  //    return map;
  //  }
  //
  //  @PostMapping("update")
  //  public String update(
  //      Board board,
  //      Part[] files,
  //      HttpSession session) 
  //          throws Exception {
  //
  //    board.setAttachedFiles(saveAttachedFiles(files));
  //
  //    checkOwner(board.getNo(), session);
  //
  //    if (!boardService.update(board)) {
  //      throw new Exception("게시글을 변경할 수 없습니다!");
  //    }
  //
  //    return "redirect:list";
  //  }
  //
  //  private void checkOwner(int boardNo, HttpSession session) throws Exception {
  //    Member loginMember = (Member) session.getAttribute("loginMember");
  //    if (boardService.get(boardNo).getWriter().getNo() != loginMember.getNo()) {
  //      throw new Exception("게시글 작성자가 아닙니다.");
  //    }
  //  }
  //
  //  @GetMapping("delete")
  //  public String delete(
  //      int no, 
  //      HttpSession session) 
  //          throws Exception {
  //
  //    checkOwner(no, session);
  //    if (!boardService.delete(no)) {
  //      throw new Exception("게시글을 삭제할 수 없습니다.");
  //    }
  //
  //    return "redirect:list";
  //  }
  //
  //  @GetMapping("fileDelete")
  //  public String fileDelete(
  //      int no,
  //      HttpSession session) 
  //          throws Exception {
  //
  //    BoardAttachedFile attachedFile = boardService.getAttachedFile(no); 
  //
  //    Member loginMember = (Member) session.getAttribute("loginMember");
  //    Board board = boardService.get(attachedFile.getBoardNo()); 
  //
  //    if (board.getWriter().getNo() != loginMember.getNo()) {
  //      throw new Exception("게시글 작성자가 아닙니다.");
  //    }
  //
  //    if (!boardService.deleteAttachedFile(no)) {
  //      throw new Exception("게시글 첨부파일을 삭제할 수 없습니다.");
  //    }
  //
  //    return "redirect:detail?no=" + board.getNo();
  //  }

  @GetMapping("main")
  public Model main(Model model) {

    // 인기 게시글 가져오기
    List<Map<String,Object>> bestList = boardService.bestList();

    // 챌린지 게시글 가져오기
    List<Map<String,Object>> clgList = boardService.clgList();

    model.addAttribute("bestList", bestList);
    model.addAttribute("clgList", clgList);

    return model;
  }

  //  제동 메서드 추가 
  @PostMapping("add") 
  public String add(
      Board board,
      int cateno,
      Part file,
      HttpSession session) throws Exception {

    // 카테고리 번호 넣기
    board.setCateno(cateno);

    board.setAttachedFiles(saveAttachedFile(file));
    //    board.setWriter((Member) session.getAttribute("loginMember"));

    boardService.add(board);
    return "redirect:list?no=" + cateno;
  }


  private List<AttachedFile> saveAttachedFile(Part file)
      throws IOException, ServletException {
    List<AttachedFile> attachedFiles = new ArrayList<>();
    String dirPath = sc.getRealPath("/board/files");

    // 첨부파일이 있다면 실행
    if (file.getSize() != 0) {
      String filename = UUID.randomUUID().toString();
      file.write(dirPath + "/" + filename);
      attachedFiles.add(new AttachedFile(filename));
    }

    return attachedFiles;
  }



  //  private String saveThumbnailFile(Part file) throws Exception {
  //    if (file.getSize() == 0) {
  //      return null;
  //    }
  //
  //    String dirPath = sc.getRealPath("/board/files");
  //
  //    String filename = UUID.randomUUID().toString();
  //    file.write(dirPath + "/" + filename);
  //
  //    return filename;
  //  }

  //  
  //  private List<AttachedFile> saveAttachedFiles(Part[] files)
  //      throws IOException, ServletException {
  //    List<AttachedFile> attachedFiles = new ArrayList<>();
  //    String dirPath = sc.getRealPath("/board/files");
  //
  //    for (Part part : files) {
  //      if (part.getSize() == 0) {
  //        continue;
  //      }
  //
  //      String filename = UUID.randomUUID().toString();
  //      part.write(dirPath + "/" + filename);
  //      attachedFiles.add(new AttachedFile(filename));
  //    }
  //    return attachedFiles;
  //  }
  //  

  @GetMapping("form")
  public void form() throws Exception {
  }

  @GetMapping("detail")
  public Model detail(int no, Model model) throws Exception {
    Board board = boardService.get(no);

    if (board == null) {
      throw new Exception("해당 번호의 게시글이 없습니다!");
    }

    return model.addAttribute("board", board);
  }


  //  @GetMapping("list")
  //  public void list(Model model, int no) throws Exception {
  //    model.addAttribute("boards", boardService.list(no));
  //  }

  @GetMapping("list")
  public ModelAndView list(Criteria cri, int no) throws Exception {


    // 페이징하기 위한 연산 
    PageMaker pageMaker = new PageMaker();
    cri.setCatenoToPage(no); // 특정 게시판을 목록을 출력하기위한 설정
    pageMaker.setCri(cri);
    pageMaker.setTotalCount(boardService.countBoardListTotal(no));


    ModelAndView mav;
    if (no == 3) {
      // 챌린지 게시판일 경우 
      mav = new ModelAndView("board/listOfClg");
    } else {
      mav = new ModelAndView("board/list");
    }

    // 게시글 카테고리 번호 Board객체에 담아서 map객체에 담을 준비 
    Board catenoInBoard = new Board();
    catenoInBoard.setCateno(no);

    List<Map<String,Object>> list = boardService.list(cri);
    System.out.println("=====>>>>>" + list.size());
    mav.addObject("list", list);
    mav.addObject("pageMaker", pageMaker);
    mav.addObject("catenoInBoard", catenoInBoard);

    return mav;
  }

  @GetMapping("delete")
  public String delete(
      int no, 
      HttpSession session) 
          throws Exception {

    // 돌아갈 게시판카테고리 넘버 찾기
    int cateno = boardService.get(no).getCateno();

    //    checkOwner(no, session);
    if (!boardService.delete(no)) {
      throw new Exception("게시글을 삭제할 수 없습니다.");
    }


    return "redirect:list?no=" + cateno;
  }

  @GetMapping("updateForm")
  public Model updateForm(int no, Model model) throws Exception {
    Board board = boardService.get(no);

    if (board == null) {
      throw new Exception("해당 번호의 게시글이 없습니다!");
    }

    return model.addAttribute("board", board);
  }

  @PostMapping("update")
  public String update(
      int cateno,
      Board board,
      Part file,
      HttpSession session) 
          throws Exception {

    board.setAttachedFiles(saveAttachedFile(file));

    //      checkOwner(board.getNo(), session);

    if (!boardService.update(board)) {
      throw new Exception("게시글을 변경할 수 없습니다!");
    }

    return "redirect:list?no=" + cateno;
  }

  // 여기부터 하자
  @GetMapping("fileDelete")
  public String boardFileDelete(
      int no,
      HttpSession session) 
          throws Exception {

    AttachedFile attachedFile = boardService.getAttachedFile(no); 

    //    Member loginMember = (Member) session.getAttribute("loginMember");
    Board board = boardService.get(attachedFile.getObjectNo()); 

    //    if (board.getWriter().getNo() != loginMember.getNo()) {
    //      throw new Exception("게시글 작성자가 아닙니다.");
    //    }

    if (!boardService.deleteAttachedFile(no)) {
      throw new Exception("게시글 첨부파일을 삭제할 수 없습니다.");
    }

    return "redirect:updateForm?no=" + board.getNo();
  }


  /////// 제동 메서드 끝 
}







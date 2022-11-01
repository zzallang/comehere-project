package com.bitcamp.testproject.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import com.bitcamp.testproject.service.BoardService;
import com.bitcamp.testproject.vo.AttachedFile;
import com.bitcamp.testproject.vo.Board;

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


  //  제동 메서드 추가 
  @PostMapping("addBoard") 
  public String addBoard(
      Board board,
      int cateno,
      Part[] files,
      HttpSession session) throws Exception {

    // 카테고리 번호 넣기
    board.setCateno(cateno);

    board.setAttachedFiles(saveBoardAttachedFiles(files));
    //    board.setWriter((Member) session.getAttribute("loginMember"));

    boardService.add(board);
    return "redirect:../";
  }

  private List<AttachedFile> saveBoardAttachedFiles(Part[] files)
      throws IOException, ServletException {
    List<AttachedFile> attachedFiles = new ArrayList<>();
    String dirPath = sc.getRealPath("/board/files");

    for (Part part : files) {
      if (part.getSize() == 0) {
        continue;
      }

      String filename = UUID.randomUUID().toString();
      part.write(dirPath + "/" + filename);
      attachedFiles.add(new AttachedFile(filename));
    }
    return attachedFiles;
  }

  @GetMapping("formBoard")
  public void formBoard() throws Exception {
  }

  @GetMapping("detailBoard")
  public Model detailBoard(int no, Model model) throws Exception {
    Board board = boardService.get(no);

    if (board == null) {
      throw new Exception("해당 번호의 게시글이 없습니다!");
    }

    return model.addAttribute("board", board);
  }

  @GetMapping("listBoard")
  public void listBoard(Model model, int no) throws Exception {
    model.addAttribute("boards", boardService.list(no));
  }

  @GetMapping("deleteBoard")
  public String deleteBoard(
      int no, 
      HttpSession session) 
          throws Exception {

    //    checkOwner(no, session);
    if (!boardService.delete(no)) {
      throw new Exception("게시글을 삭제할 수 없습니다.");
    }

    return "redirect:listBoard";
  }

  @GetMapping("updateFormBoard")
  public Model updateFormBoard(int no, Model model) throws Exception {
    Board board = boardService.get(no);

    if (board == null) {
      throw new Exception("해당 번호의 게시글이 없습니다!");
    }

    return model.addAttribute("board", board);
  }

  @PostMapping("updateBoard")
  public String updateBoard(
      int cateno,
      Board board,
      Part[] files,
      HttpSession session) 
          throws Exception {

    board.setAttachedFiles(saveBoardAttachedFiles(files));

    //      checkOwner(board.getNo(), session);

    if (!boardService.update(board)) {
      throw new Exception("게시글을 변경할 수 없습니다!");
    }

    return "redirect:listBoard?no=" + cateno;
  }

  // 여기부터 하자
  @GetMapping("boardFileDelete")
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

    return "redirect:updateFormBoard?no=" + board.getNo();
  }


  /////// 제동 메서드 끝 
}







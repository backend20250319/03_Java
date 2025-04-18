package com.ohgiraffers.hw2.view;

import com.ohgiraffers.hw2.model.dto.BoardDTO;

import java.util.Date;
import java.util.Scanner;

public class InputBoard {
    Scanner sc = new Scanner(System.in);

    public BoardDTO inputBoard() {
        String boardTitle = inputBoardTitle();
        System.out.println("작성자 이름을 입력해주세요.");
        String boardWriter = sc.nextLine();
        int boardNo = inputBoardNo();
        Date boardDate = new Date();
        String boardContent = inputBoardContent();
        int readCount = 0;

        BoardDTO boardDTO = new BoardDTO(boardNo, boardTitle, boardWriter, boardDate, boardContent, readCount);
        return boardDTO;
    };

    public int inputBoardNo() {
        System.out.println("글 번호를 입력하세요 : ");
        int boardNo = sc.nextInt();
        return boardNo;
    };

    public String inputBoardTitle() {
        System.out.println("글 제목을 입력해주세요 : ");
        String boardTitle = sc.nextLine();
        return boardTitle;
    };

    public String inputBoardContent() {
        System.out.println("================= 글 내용 (입력 종료 : exit) =================");
        StringBuilder boardContent = new StringBuilder();

        while (true) {
            String line = sc.nextLine();
            if(line.equals("exit")) {
                break;
            }
            boardContent.append(line).append("\n");
        }
        return boardContent.toString();
    };

}


package com.ohgiraffers.hw2.controller;

import com.ohgiraffers.hw2.model.comparator.AscBoardDate;
import com.ohgiraffers.hw2.model.dto.BoardDTO;
import com.ohgiraffers.hw2.view.ResultPrinter;

import java.util.ArrayList;
import java.util.Comparator;

public class BoardManager {

    private ArrayList<BoardDTO> boardList= new ArrayList<>();

    private ResultPrinter rp;

    public void insertBoard(BoardDTO b) {
        int boardNo = 0;
        if (boardList == null) {
            boardList = new ArrayList<>();
            boardNo++;
        } else {
            boardNo = boardList.get(boardList.size() - 1).getBoardNo() + 1;
        }
        b.setBoardNo(boardNo);
        boardList.add(b);

        rp.successPage("insertBoard");
    }


    public void selectAllList() {

        if (boardList == null || boardList.isEmpty()) {
            System.out.println("게시글이 존재하지 않습니다.");
        } else {
            for (BoardDTO board : boardList) {
                System.out.println(board);
            }
        }
    }


    public void selectOneBoard(int boardNo) {

        BoardDTO selectedBoard = null;

        if (boardList != null) {
            for (int i = 0; i < boardList.size(); i++) {

                if (boardList.get(i).getBoardNo() == boardNo) {
                    selectedBoard = boardList.get(i);
                    /* 조회수 1 증가 */
                    boardList.get(i).setReadCount(boardList.get(i).getReadCount() + 1);
                    break;
                }
            }
        }
        if (selectedBoard == null) {
            rp.errorPage("selectOne");
        } else {
            rp.printBoard(selectedBoard);
        }
    }

    public void updateBoardTitle(int boardNo, String title) {
        int boardNoToUpdate = 0;
        for (BoardDTO board : boardList) {
            if (board.getBoardNo() == boardNo) {
                board.setBoardTitle(title);
                boardNoToUpdate = board.getBoardNo();
                break;
            }
        }
        if (boardNoToUpdate == 0) {
            rp.errorPage("updateTitle");
        } else {
            rp.successPage("updateTitle");
        }

    }

    public void updateBoardContent(int boardNo, String content) {
        int boardNoToUpdate = 0;
        for (BoardDTO board : boardList) {
            if (board.getBoardNo() == boardNo) {
                board.setBoardTitle(content);
                boardNoToUpdate = board.getBoardNo();
                break;
            }
        }
        if (boardNoToUpdate == 0) {
            rp.errorPage("updateContent");
        } else {
            rp.successPage("updateContent");
        }
    }

    public void deleteBoard(int boardNo) {
        int boardNoToUpdate = 0;
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getBoardNo() == boardNo) {
                boardNoToUpdate = boardList.get(i).getBoardNo();
                boardList.remove(i);
                break;
            }
        }
        if (boardNoToUpdate == 0) {
            rp.errorPage("deleteBoard");
        } else {
            rp.successPage("deleteBoard");
        }

    }

    public void searchBoard(String title) {

        ArrayList<BoardDTO> searchList = new ArrayList<>();

        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getBoardTitle().contains(title)) {
                searchList.add(boardList.get(i));
            }
        }
        if (searchList.isEmpty()) {
            rp.noSearchResult();
        } else {
            rp.printAllList(searchList);
        }

    }

    public void sortList(Comparator<BoardDTO> c) {
        boardList.sort(c);
        rp.printAllList(boardList);
    }
}

































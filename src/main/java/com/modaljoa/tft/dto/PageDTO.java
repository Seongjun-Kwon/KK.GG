package com.modaljoa.tft.dto;

import lombok.Data;

@Data
public class PageDTO {

    private int pageSize = 100;
    private int blockSize = 10;
    private int startIdx;
    private int totalCount;
    private int curPage;
    private int blockStartPage;
    private int blockEndPage;
    private int totalPageCount;
    private int prevBlock;
    private int nextBlock;


    public PageDTO(int curPage, int totalCount) {
        this.startIdx = (curPage - 1) * pageSize + 1;
        this.totalCount = totalCount;
        this.curPage = curPage;
        this.totalPageCount = (int) Math.ceil(this.totalCount / pageSize);
        this.blockEndPage = (int) (Math.ceil(curPage / (double) blockSize)) * blockSize > totalPageCount ? totalPageCount : (int) (Math.ceil(curPage / (double) blockSize)) * blockSize;
        this.blockStartPage = (this.blockEndPage - 9) < 1 ? 1 : this.blockEndPage - 9;
        this.prevBlock = this.blockStartPage > 1 ? blockStartPage - 1 : 1;
        this.nextBlock = this.blockEndPage < totalPageCount ? blockEndPage + 1 : totalPageCount;
    }
}

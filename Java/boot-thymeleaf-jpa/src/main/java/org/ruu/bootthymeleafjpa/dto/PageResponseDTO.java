package org.ruu.bootthymeleafjpa.dto;


import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageResponseDTO<T> {
    private int page;
    private int size;
    private int total;

    private int start;
    private int end;

    private boolean prev;
    private boolean next;

    private List<T> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<T> dtoList, int total){
        if(total <= 0){
            return;
        }
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        this.end = (int)(Math.ceil((this.page/(double)this.size))) * 10; // 화면에서 마지막 번호
        this.start = this.end - this.size + 1;

        int last = (int)(Math.ceil((total/(double)size))); // 데이터 개수를 계산한 마지막 페이지번호

        this.end = this.end > last ? last : end;

        this.prev = this.page > 10;

        this.next = total > this.end * this.size;


    }
}

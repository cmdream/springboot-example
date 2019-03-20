package utils;

public class PageUtils {
    private String page;
    private int count;
    private int pageSize;
    private int currentPage;
    private int prevPage;
    private int nextPage;
    private int lastPage;
    public PageUtils(String page,int count,int pageSize){
        this.page=page;
        if(null==this.page){
            this.page="1";
        }

        this.count=count;
        this.pageSize=pageSize;
        currentPage=Integer.parseInt(this.page);
        prevPage=currentPage==1?1:currentPage-1;
        initLastPage();
        initNextPage();

    }
    private void initNextPage() {
        nextPage=currentPage==lastPage?lastPage:currentPage+1;

    }
    private void initLastPage() {
        lastPage=count/pageSize;
        if(count%pageSize!=0){
            lastPage+=1;
        }

    }
    public String getPage() {
        return page;
    }
    public void setPage(String page) {
        this.page = page;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPrevPage() {
        return prevPage;
    }
    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }
    public int getNextPage() {
        return nextPage;
    }
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    public int getLastPage() {
        return lastPage;
    }
    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }
}

public class Pagination {

  public static void main(String []args){
    System.out.println(Integer.toString(0xff));
    generatePaginationNumbers(150, 5, 13);
    generatePaginationNumbers(60, 20, 2);
  }

  public static void generatePaginationNumbers(int totalItems, int pageSize, int currentPage) {
    int DELTA = 3;
    int SHOW_ALL_SIZE = 10;
    int lastPage = totalItems/pageSize;
    if (totalItems > lastPage * pageSize) {
      lastPage++;
    }

    currentPage = currentPage < 1 ? 1 : currentPage;
    if (currentPage > lastPage) {
      currentPage = 1;
    }

    if (totalItems < 1) {
      return;
    }

    if (currentPage > 1) {
      System.out.print("prev ");
    }
    printPaginationPage(1, currentPage);
    if (totalItems > pageSize) {
      printPaginationPage(2, currentPage);
    } else {
      return;
    }

    if (currentPage - DELTA > 3 && lastPage > SHOW_ALL_SIZE) {
      System.out.print(" ... ");
    }

    int page = lastPage > SHOW_ALL_SIZE ? currentPage - DELTA : 3;
    page = page <= 2 ? 3 : page;
    int end = currentPage + DELTA;
    end = end >= lastPage - 1 ? lastPage - 2 : end;
    for( ; page <= end; page++) {
      printPaginationPage(page, currentPage);
    }

    if (page <= lastPage - 2 && lastPage > SHOW_ALL_SIZE) {
      System.out.print(" ... ");
    }

    if (lastPage - 1 >= page) {
      printPaginationPage(lastPage - 1, currentPage);
    }
    if (lastPage >= page) {
      printPaginationPage(lastPage, currentPage);
    }

    if (currentPage < lastPage) {
      System.out.print("next");
    }
  }



  public static void printPaginationPage(int page, int current) {
    if (page == current) {
      System.out.print("[" + page + "] ");
    } else {
      System.out.print(page + " ");
    }
  }
}
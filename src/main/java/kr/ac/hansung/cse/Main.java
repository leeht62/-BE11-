package kr.ac.hansung.cse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("== 명언 앱 ==");
    String a;
    List<Talk> al = new ArrayList<>();
    int k = 0;
    while (true) {
      System.out.print("명령)" );
      a= sc.nextLine();
      if (a.equals("등록")) {
        System.out.print("명언 :");
        String b = sc.nextLine();
        System.out.print("작가: ");
        String c = sc.nextLine();
        k++;
        Talk tk=new Talk(k,b,c);
        al.add(tk);
        System.out.println(k+"번 명언이 등록되었습니다.");
      }else if(a.equals("종료")){
        System.out.print("명령) 종료");
        break;
      }else if(a.equals("목록")){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(int i= al.size()-1;i>=0;i--){
          Talk as=al.get(i);
          System.out.println((i+1)+" / "+as.author+" / "+ as.content);
        }
      }else if(a.startsWith("삭제?id=")){
        int m=Integer.parseInt(a.substring(6));
        boolean delete=false;

        for(int i=0;i<al.size();i++){
          if(al.get(i).id==m){
            al.remove(i);
            System.out.println((i+1)+"번 명언이 삭제되었습니다.");
            delete=true;
            break;
          }
        }
        if(!delete){
          System.out.println(m+"번 명언은 존재하지 않습니다.");
        }
      }else if(a.startsWith("수정?id=")) {
        int m=Integer.parseInt(a.substring(6));
        for(int i=0;i<al.size();i++){
          if(al.get(i).id==m){
            System.out.println("명언(기존) : "+al.get(i).content);
            System.out.print("명언 :");
            String b = sc.nextLine();
            System.out.println("작가(기존) : "+al.get(i).author);
            System.out.print("작가: ");
            String c = sc.nextLine();
            Talk tk=new Talk(m,b,c);
            al.set(i,tk);
            System.out.println(m + "번 명언이 수정되었습니다.");
            break;
          }
        }
      }
    }

  }
}

class Talk {
  int id;
  String content;
  String author;

  Talk(int id, String content, String author) {
    this.id = id;
    this.content = content;
    this.author = author;
  }
}
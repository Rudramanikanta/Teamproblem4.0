import java.util.*;

public class Matcher {
    public static void main(String[] args) {
        ArrayList<String> as = new ArrayList<>();
        Teams t = new Teams();
        t.setTeam1("team1");
        t.setTeam2("team2");
        t.setTeam3("team3");
        t.setTeam4("team4");
        t.setTeam5("team5");
        as.add(t.getTeam1());
        as.add(t.getTeam2());
        as.add(t.getTeam3());
        as.add(t.getTeam4());
        as.add(t.getTeam5());
        Sechudler sc = new Sechudler();
        ArrayList<HashMap<String, String>> hm = sc.shedule(as);
        WinnerMaker w = new WinnerMaker();
        w.winnerOfMatch(hm);
    }
}

class Teams {
    private String team1;
    private String team2;
    private String team3;
    private String team4;
    private String team5;

    public void setTeam1(String str) {
        team1 = str;
    }

    public void setTeam2(String str) {
        team2 = str;
    }

    public void setTeam3(String str) {
        team3 = str;
    }

    public void setTeam4(String str) {
        team4 = str;
    }

    public void setTeam5(String str) {
        team5 = str;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getTeam3() {
        return team3;
    }

    public String getTeam4() {
        return team4;
    }

    public String getTeam5() {
        return team5;
    }
}

class Sechudler {
    public ArrayList<HashMap<String, String>> shedule(ArrayList<String> as) {
        ArrayList<HashMap<String, String>> al = new ArrayList<>();
        for (int i = 0; i < as.size(); i++) {
            HashMap<String, String> hm = new HashMap<>();
            for (int j = i + 1; j < as.size(); j++) {
                hm.put(as.get(j), as.get(i));
            }
            al.add(hm);
        }
        return al;
    }
}

class WinnerMaker {
    public void winnerOfMatch(ArrayList<HashMap<String, String>> as) {
        HashMap<String,Integer> hm3=new HashMap<>();
        for (HashMap<String, String> hm : as) {
            for (Map.Entry<String, String> hm2 : hm.entrySet()) {
                if (hm2.getKey() != null) {
                  hm3=winner(hm2.getKey(),hm2.getValue());
                }
                System.out.println(hm3);
            }
           
        }
    }
    public HashMap<String,Integer> winner(String str,String str2){
        String winner="";
        String looser="";
        HashMap<String,Integer> al=new HashMap<>();
        Random ran=new Random();
        int point=(int)ran.nextInt(2);
      
        if(point==0){
            winner=str;
            looser=str2;
        }
        if(point==1){
            winner=str2;
            looser=str;
        }
        al.put(winner,1);
        al.put(looser,0);
      
        return al;
    }
}
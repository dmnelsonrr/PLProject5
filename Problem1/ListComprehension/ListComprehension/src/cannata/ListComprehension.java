package cannata;

import java.util.*;
import java.util.List;

public class ListComprehension {

    public static void main(String[] args) {

        //create instance of ArrayList for employee table
        ArrayList<List<Object>> emp = new ArrayList<>();

        //each employee/row as a list of objects
        List<Object> e1 = Arrays.asList("ID","LAST_NAME","FIRST_NAME","USERID","START_DATE","COMMENTS","TITLE","SALARY","COMMISSION","DEPT_ID","MANAGER_ID");
        List<Object> e2 = Arrays.asList(1, "Martin","Carmen", "martincu", "3-Mar-90", "", "President", 4500, "", 50, "");
        List<Object> e3 = Arrays.asList(10, "Jackson", "Marta", "jacksomt", "27-Feb-91", "", "Warehouse Manager", 1507, "", 45, 2);
        List<Object> e4 = Arrays.asList(11, "Henderson", "Colin", "hendercs", "14-May-90", "", "Sales Representative", 1400, 10, 31, 3);
        List<Object> e5 = Arrays.asList(12, "Gilson", "Sam", "gilsonsj", "18-Jan-92", "", "Sales Representative", 1490, 12.5, 32, 3);
        List<Object> e6 = Arrays.asList(13, "Sanders", "Jason", "sanderjk", "18-Feb-91", "", "Sales Representative", 1515, 10, 33, 3);
        List<Object> e7 = Arrays.asList(14, "Dameron", "Andre", "dameroap", "9-Oct-91", "", "Sales Representative", 1450, 17.5, 35, 3);
        List<Object> e8 = Arrays.asList(15, "Hardwick", "Elaine", "hardwiem", "7-Feb-92", "", "Stock Clerk", 1400, "", 41, 6);
        List<Object> e9 = Arrays.asList(16, "Brown", "George", "browngw", "8-Mar-90", "", "Store Clerk", 940, "", 41, 6);
        List<Object> e10 = Arrays.asList(17, "Washington", "Thomas", "washintl", "9-Feb-91", "", "Store Clerk", 1200, "", 42, 7);
        List<Object> e11 = Arrays.asList(18, "Patterson", "Donald", "patterdv", "6-Aug-91", "", "Store Clerk", 795, "", 42, 7);
        List<Object> e12 = Arrays.asList(19, "Bell", "Alexander", "bellag", "26-May-91", "", "Store Clerk", 850, "", 43, 8);
        List<Object> e13 = Arrays.asList(2, "Smith", "Doris", "smithdj", "8-Mar-90", "", "VP, Operations", 2450, "", 41, 1);
        List<Object> e14 = Arrays.asList(20, "Gantos", "Eddie", "gantosej", "30-Nov-90", "", "Store Clerk", 800, "", 44, 9);
        List<Object> e15 = Arrays.asList(21, "Stephenoson", "Blaine", "stephebs", "17-Mar-91", "", "Store Clerk", 860, "", 45, 10);
        List<Object> e16 = Arrays.asList(22, "Chester", "Eddie", "chesteek", "30-Nov-90", "", "Store Clerk", 800, "", 44, 9);
        List<Object> e17 = Arrays.asList(23, "Pearl", "Roger", "pearlrg", "17-Oct-90", "", "Store Clerk", 795, "", 34, 9);
        List<Object> e18 = Arrays.asList(24, "Dancer", "Bonnie", "dancerbw", "17-Mar-91", "", "Store Clerk", 860, "", 45, 7);
        List<Object> e19 = Arrays.asList(25, "Schmitt", "Sandra", "schmitss", "9-May-91", "", "Store Clerk", 1100, "", 45, 8);
        List<Object> e20 = Arrays.asList(3, "Norton", "Michael", "nortonma", "17-Jun-91", "", "VP, Sales", 2400, "", 31, 1);
        List<Object> e21 = Arrays.asList(4, "Quenin", "Mark", "quentiml", "7-Apr-90", "", "VP, Finance", 2450, "", 10, 1);
        List<Object> e22 = Arrays.asList(5, "Roper", "Joseph", "roperjm", "4-Mar-90", "", "VP, Administration", 2550, "", 50, 1);
        List<Object> e23 = Arrays.asList(6, "Brown", "Molly", "brownmr", "18-Jan-91", "", "Warehouse Manager", 1600, "", 41, 2);
        List<Object> e24 = Arrays.asList(7, "Hawkins", "Roberta", "hawkinrt", "14-May-90", "", "Warehouse Manager", 1650, "", 42, 2);
        List<Object> e25 = Arrays.asList(8, "Burns", "Ben", "burnsba", "7-Apr-90", "", "Warehouse Manager", 1500, "", 43, 2);
        List<Object> e26 = Arrays.asList(9, "Catskill", "Antoinette", "catskiaw", "9-Feb-92", "", "Warehouse Manager", 1700, "", 44, 2);

        //add all employee lists to the employee ArrayList
        emp.add(e1);emp.add(e2);emp.add(e3);emp.add(e4);emp.add(e5);emp.add(e6);emp.add(e7);emp.add(e8);emp.add(e9);emp.add(e10);
        emp.add(e11);emp.add(e12);emp.add(e13);emp.add(e14);emp.add(e15);emp.add(e16);emp.add(e17);emp.add(e18);emp.add(e19);emp.add(e20);
        emp.add(e21);emp.add(e22);emp.add(e23);emp.add(e24);emp.add(e25);emp.add(e26);

        //stream pipelines
        System.out.println("Select * from emp where commission <> \"\"");
        emp.stream()
                .filter(e -> !(e.get(8).toString().equals("")))
                .forEach(e -> System.out.println(e));

        System.out.println("\nSelect last_name from emp order by last_name offset 1");
        emp.stream()
                .skip(1)
                .map(e -> e.get(1))
                .sorted()
                .forEach(e -> System.out.println(e));

        System.out.println("\nSelect * from emp where title = \"Store Clerk\"");
        emp.stream()
                .filter(e -> e.get(6).toString().equals("Store Clerk"))
                .forEach(e -> System.out.println(e));

        System.out.println("\nSelect distinct title from emp order by title offset 1");
        emp.stream()
                .skip(1)
                .map(e -> e.get(6))
                .sorted()
                .distinct()
                .forEach(e -> System.out.println(e));

        System.out.println("\nSelect * from emp where salary >= 1500 offset 1");
        emp.stream()
                .skip(1)
                .filter(e -> (Integer)e.get(7) >= 1500)
                .forEach(e -> System.out.println(e));
    }
}

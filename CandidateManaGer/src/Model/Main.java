package Model;

public class Main {
    public static void main(String[] args) {
        Experience experience = new Experience();
        experience.setCandidateID(System.currentTimeMillis()/1000);
        experience.setBirthday("08/04/1998");
        experience.setEmail("truongthanh11201@gmail.com");
        experience.setFullName("Truong Van Thanh");
        experience.setPhoneNumber("0962435396");
        experience.setCandidateType(0);
        experience.setProSkill("Boc phet");
        experience.setExpInYear(5);
        Experience experience1 = new Experience(System.currentTimeMillis()/1000,"Phap","15/8/2000","0154284586","phsp@gmail.com",2,"chem gio");
        experience1.setCandidateType(1);
        System.out.println(experience1.toString());
        System.out.println(experience.toString());
    }
}

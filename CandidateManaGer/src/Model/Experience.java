package Model;

public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(Long CandidateID, String fullName, String birthday, String phoneNumber, String email, int expInYear, String proSkill) {
        setCandidateID(CandidateID);
        setBirthday(birthday);
        setFullName(fullName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() +"Experience{" +
                "expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                "} " ;
    }
}

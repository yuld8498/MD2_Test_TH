package Model;

import java.util.Date;

public class Candidate implements CandidateType {
    private Long candidateID;
    private String fullName;
    private String birthday;
    private String phoneNumber;
    private String email;

    Candidate(Long candidateID, String fullName, String birthday, String phoneNumber, String email) {
        this.candidateID = candidateID;
        this.fullName = fullName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    Candidate() {

    }

    public Long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Long candidateID) {
        this.candidateID = candidateID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void Showinfo(Candidate candidate) {
        System.out.println(candidate.toString());
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateID=" + candidateID +
                ", fullName='" + fullName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                "} ";
    }
    @Override
    public String setCandidateType(int number) {
        switch (number){
            case 0: return "Experience";
            case 1: return "Fresher";
            case 2: return "Intern";
        }
        return null;
    }
}

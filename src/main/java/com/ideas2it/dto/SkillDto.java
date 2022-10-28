package com.ideas2it.dto;

public class SkillDto {
    private Integer skillId;
    private String skillName;
    private String skillVersion;
    private Integer lastUsedYear;
    private Float skillExperience;
    private Integer traineeId;

    private TraineeDto traineeDto;

    public SkillDto() {
    }

    public SkillDto(Integer skillId, String skillName, String skillVersion, Integer lastUsedYear,
                    Float skillExperience) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillVersion = skillVersion;
        this.lastUsedYear = lastUsedYear;
        this.skillExperience = skillExperience;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillVersion() {
        return skillVersion;
    }

    public void setSkillVersion(String skillVersion) {
        this.skillVersion = skillVersion;
    }

    public Integer getLastUsedYear() {
        return lastUsedYear;
    }

    public void setLastUsedYear(Integer lastUsedYear) {
        this.lastUsedYear = lastUsedYear;
    }

    public Float getSkillExperience() {
        return skillExperience;
    }

    public void setSkillExperience(Float skillExperience) {
        this.skillExperience = skillExperience;
    }

    public Integer getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Integer traineeId) {
        this.traineeId = traineeId;
    }

    public TraineeDto getTraineeDto() {
        return traineeDto;
    }

    public void setTraineeDto(TraineeDto traineeDto) {
        this.traineeDto = traineeDto;
    }

    public String toString() {
        return ("\nSkillId : " + skillId + "List Of Skills : " + skillName + "\nVersion : " + skillVersion +
                "\nLast Used Year : " + lastUsedYear + "\nSkill Experience : " + skillExperience);
    }
}

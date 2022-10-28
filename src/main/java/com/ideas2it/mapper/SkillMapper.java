package com.ideas2it.mapper;

import com.ideas2it.dto.SkillDto;
import com.ideas2it.model.Skills;

import java.util.LinkedHashSet;
import java.util.Set;

public class SkillMapper {

    public static Set<Skills> convertSkillDtoToSkill(Set<SkillDto> skillsDto) {
        Set<Skills> skills = new LinkedHashSet<Skills>();
        for (SkillDto skillDto : skillsDto) {
            Skills skill = new Skills(skillDto.getSkillId(), skillDto.getSkillName(),
                    skillDto.getSkillVersion(), skillDto.getLastUsedYear(),
                    skillDto.getSkillExperience());
            skills.add(skill);
        }
        return skills;
    }

    public static Set<SkillDto> convertSkillToSkillDto(Set<Skills> skills) {
        Set<Skills> traineeSkills = skills;
        Set<SkillDto> skillsDto = new LinkedHashSet<SkillDto>();
        for (Skills skill : traineeSkills) {
            SkillDto skillDto = new SkillDto(skill.getSkillId(), skill.getSkillName(),
                    skill.getSkillVersion(), skill.getLastUsedYear(),
                    skill.getSkillExperience());
            skillsDto.add(skillDto);
        }
        return skillsDto;
    }
}
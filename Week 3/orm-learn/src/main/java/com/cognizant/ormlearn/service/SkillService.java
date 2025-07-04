package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.entity.Skill;
import com.cognizant.ormlearn.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return (List<Skill>) skillRepository.findAll();
    }

    public Skill getSkillById(int id) {
        return skillRepository.findById(id).orElse(null);
    }

    public void saveSkill(Skill skill) {
        skillRepository.save(skill);
    }

    public void deleteSkill(int id) {
        skillRepository.deleteById(id);
    }
}


package com.expertcode.exercicio_4.entities.mapper;

import com.expertcode.exercicio_4.entities.Grid;
import com.expertcode.exercicio_4.entities.SchoolSubjects;
import com.expertcode.exercicio_4.entities.dto.GridDTO;
import com.expertcode.exercicio_4.repositories.SchoolSubjectsRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GridMapper {

    @Mapping(target = "listSchoolSubjects", source = "listSchoolSubjects", qualifiedByName = "mapSchoolSubjectsToIds")
    GridDTO toGridDTO(Grid grid);

    @Mapping(target = "listSchoolSubjects", source = "listSchoolSubjects", qualifiedByName = "mapIdsToSchoolSubjects")
    Grid toGrid(GridDTO dto, @Context SchoolSubjectsRepository repo);

    @Named("mapSchoolSubjectsToIds")
    static List<Long> mapSchoolSubjectsToIds(List<SchoolSubjects> subjects) {
        if (subjects == null) return new ArrayList<>();
        return subjects.stream().map(SchoolSubjects::getId).toList();
    }

    @Named("mapIdsToSchoolSubjects")
    static List<SchoolSubjects> mapIdsToSchoolSubjects(List<Long> ids, @Context SchoolSubjectsRepository repo) {
        if (ids == null) return new ArrayList<>();
        return ids.stream()
                .map(repo::getReferenceById)
                .toList();
    }
}

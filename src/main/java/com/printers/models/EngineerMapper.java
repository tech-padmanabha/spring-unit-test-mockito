package com.printers.models;

import com.printers.entities.Engineer;
import com.printers.views.EngineerDto;

public class EngineerMapper {
    public static EngineerDto toDto(Engineer engineer){
        return new EngineerDto(engineer.name(), engineer.email(), engineer.phone(), engineer.address(), engineer.department(), engineer.role());
    }

    public static Engineer toEntity(EngineerDto engineer){
        return new Engineer(null,engineer.name(), engineer.email(), engineer.phone(), engineer.address(), engineer.department(), engineer.role());
    }
}

package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Department;
import peaksoft.service.DepartmentService;

@RequestMapping("departments")
@Controller                 // BEAN TYZOT
@RequiredArgsConstructor
public class DepartmentApi {

    private final DepartmentService departmentService;
    private  Long hospitalId;



    @GetMapping("/{hospitalId}")
    public String getAllDepartment(Model model, @PathVariable("hospitalId") Long id) {
        model.addAttribute("departments", departmentService.getAllDepartment(id));
        hospitalId=id;
        return "department/getAllDepartments";
    }

    @GetMapping("/{id}/new")
    String newDepartment(Model model, @PathVariable("id") Long id) {
        model.addAttribute("newDepartment", new Department());
        model.addAttribute("hospitalId", id);
        return "department/newDepartments";
    }

    @PostMapping("/{id}/save")
    String saveDepartment(@PathVariable("id") Long id,
                          @ModelAttribute("department") Department department) {
        departmentService.saveDepartment(id, department);
        return "redirect:/departments/"+id;
    }

    @PostMapping("/deleteDepartment/{departmentId}")
    String deleteDepartment(@PathVariable("departmentId") Long id) {
        departmentService.deleteDepartmentById(id);
        return "redirect:/departments/"+hospitalId;
    }

}

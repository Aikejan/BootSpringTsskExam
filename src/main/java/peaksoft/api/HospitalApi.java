package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Hospital;
import peaksoft.service.HospitalService;

@RequestMapping("hospitals")
@Controller                 // BEAN TYZOT
@RequiredArgsConstructor
public class HospitalApi {
    private final HospitalService hospitalService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("allHospitals", hospitalService.getAllHospital());
        return "hospital/getAllHospitals";

    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("newHospital", new Hospital());
        return "hospital/newHospital";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute("newHospital") Hospital hospital) {
        hospitalService.saveHospital(hospital);
        return "redirect:/hospitals";

    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("hospitalId") Long id){
        hospitalService.removeHospitalById(id);
        return "redirect:/hospitals";

    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id){
        model.addAttribute("oldHospital", hospitalService.getHospitalById(id));
        return "hospital/updateHospital";

    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute("hospital") Hospital hospital){
        hospitalService.updateHospital(id, hospital);
        return "redirect:hospitals";

    }

}






















//    @GetMapping("/allHospital")
//    public String getAllHospitals(Model model) {
//        model.addAttribute("allHospitals", hospitalService.getAllHospitals());
//        return "/getAllHospital";
//    }
//
//
//
//    @GetMapping("/create")
//    String createHospital(Model model) {
//        model.addAttribute("newHospital", new Hospital());
//        return "/saveHospital";
//    }
//    @PostMapping("/save")
//    String saveHospital(@ModelAttribute("newHospital") Hospital hospital) {
//        hospitalService.saveHospital(hospital);
//        return "redirect:/allHospital";
//    }
//    @RequestMapping("/delete")
//    public String deleteById(@RequestParam("hospitalId") Long id,Model model) {
//      model.addAttribute("");
//        return "redirect:/hospitals";
//    }
//
//    public String editHospital(Model model, @PathVariable("id") Long id){
//        model.addAttribute("odlHospital", hospitalService.getHospitalById(id));
//        return "hospital/updateHospital";
//    }
//
//    @PostMapping("/{id}/update")
//    public String updateHospital(@PathVariable("id") Long id, @ModelAttribute("hospital") Hospital newHospital){
//        hospitalService.updateHospital(id, newHospital);
//        return "redirect:/hospitals";
//    }





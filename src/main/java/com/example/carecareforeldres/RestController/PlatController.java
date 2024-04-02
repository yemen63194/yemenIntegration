package com.example.carecareforeldres.RestController;

import com.example.carecareforeldres.DTO.PlatWithIngredientsDTO;
import com.example.carecareforeldres.Entity.Plat;
import com.example.carecareforeldres.Repository.IngredientRepository;
import com.example.carecareforeldres.Repository.PlatRepository;
import com.example.carecareforeldres.Service.PlatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/plat")
@CrossOrigin("*")
public class PlatController {
    PlatService platService;
    PlatRepository platRepository;
IngredientRepository ingredientRepository;

   /* @PostMapping("/add")
    public Plat ajouterPlat(@RequestBody Plat res){
        Logger.getLogger("amin").warning("amin"+res.toString());

        Plat p1=platService.addPlat(res);
        return p1;
    }*/

    @GetMapping("/retrive_all_plat")
    public List<Plat> retrievePlatList(){

        return platService.getAll();
    }

    @GetMapping("/retrive_plat/{platId}")
    public Plat retrievePlat(@PathVariable("platId") Integer platId){

        return platRepository.findById(platId).get();
    }

    @PutMapping("/update_plat")
    public Plat updatePlat(@RequestBody Plat plat){

        return platService.update(plat);
    }

    @DeleteMapping("/delete_plat/{platId}")
    public void deletePlat(@PathVariable("platId") Integer platId){
        platService.remove(platId);
    }
    /* @PostMapping("/addPlatWithIngredients")
    public Plat addPlatWithIngredients(@RequestBody Plat plat) {
        return platService.addPlatWithIngredients(plat);
    }
   @PostMapping("/aff")
    public ResponseEntity<Plat> ajouterPlatAvecIngredients(@RequestBody Plat plat, @RequestBody List<Ingredient> ingredients) {
        Plat nouveauPlat = platService.ajouterPlatAvecIngredients(plat, ingredients);
        return new ResponseEntity<>(nouveauPlat, HttpStatus.CREATED);
    }*/


    @PostMapping("/add_plat/{idPatient}")
    public Plat addPlat(@RequestBody Plat plat,@PathVariable("idPatient") Integer idPatient){
       return platService.addPlatPatient(plat,idPatient);
    }

    @PostMapping("/test/{idPatient}")
    public Boolean test(@RequestBody Plat plat,@PathVariable("idPatient") Integer idPatient){
        return platService.testMaladie(plat,idPatient);
    }


    @PostMapping("/addPlatWithIngredients")
    public Plat addPlatWithIngredients(@RequestBody PlatWithIngredientsDTO platDTO) {
        return platService.addPlatDTO(platDTO);
    }


}

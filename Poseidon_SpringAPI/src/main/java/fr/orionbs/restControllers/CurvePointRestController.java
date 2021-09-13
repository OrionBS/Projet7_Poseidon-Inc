package fr.orionbs.restControllers;

import fr.orionbs.dto.CurvePointDTO;
import fr.orionbs.services.CurvePointService;
import fr.orionbs.services.impl.CurvePointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/curve-point")
public class CurvePointRestController {

    @Autowired
    CurvePointService curvePointService;

    @PostMapping
    public ResponseEntity<Boolean> creatingCurvePoint(@RequestBody CurvePointDTO curvePointDTO) {

        boolean answer = curvePointService.creatingCurvePoint(curvePointDTO);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/{index}")
    public ResponseEntity<CurvePointDTO> readingCurvePoint(@PathVariable(value = "index") Integer index) {

        CurvePointDTO curvePointDTO = curvePointService.readingCurvePoint(index);

        if (curvePointDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(curvePointDTO, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CurvePointDTO>> readingAllCurvePoint() {

        List<CurvePointDTO> curvePointDTOList = curvePointService.readingAllCurvePoint();

        return new ResponseEntity<>(curvePointDTOList, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Boolean> updatingCurvePoint(@RequestBody CurvePointDTO curvePointDTO) {

        boolean answer = curvePointService.updatingCurvePoint(curvePointDTO);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> deletingCurvePoint(@RequestParam(value = "index") Integer index) {

        boolean answer = curvePointService.deletingCurvePoint(index);

        if (answer) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

}

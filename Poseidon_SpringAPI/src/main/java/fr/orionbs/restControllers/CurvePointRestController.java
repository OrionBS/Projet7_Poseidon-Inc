package fr.orionbs.restControllers;

import fr.orionbs.dataTransferObjects.CurvePointDTO;
import fr.orionbs.services.CurvePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CurvePointRestController {

    @Autowired
    CurvePointService curvePointService;

    @PostMapping(path = "/curvePoint/creating")
    public boolean creatingCurvePoint(CurvePointDTO curvePointDTO) {
        boolean answer = curvePointService.creatingCurvePoint(curvePointDTO);
        if (answer) {
            return true;
        }
        return false;
    }

    @GetMapping(path = "/curvePoint/reading")
    public CurvePointDTO readingCurvePoint(Integer index) {
        return curvePointService.readingCurvePoint(index);
    }

    @GetMapping(path = "/curvePoint/readingAll")
    public List<CurvePointDTO> readingAllCurvePoint() {
        return curvePointService.readingAllCurvePoint();
    }

    @PutMapping(path = "/curvePoint/updating")
    public boolean updatingCurvePoint(CurvePointDTO curvePointDTO) {
        boolean answer = curvePointService.updatingCurvePoint(curvePointDTO);
        if (answer) {
            return true;
        }
        return false;
    }

    @DeleteMapping(path = "/curvePoint/deleting")
    public boolean deletingCurvePoint(Integer index) {
        boolean answer = curvePointService.deletingCurvePoint(index);
        if (answer) {
            return true;
        }
        return false;
    }

}

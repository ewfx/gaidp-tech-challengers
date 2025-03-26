import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiling")
public class ProfilingController {

    @Autowired
    private ProfilingService profilingService;

    @PostMapping("/process")
    public ResponseEntity<?> processTransactions(@RequestBody List<Transaction> transactions) {
        return ResponseEntity.ok(profilingService.processTransactions(transactions));
    }
}
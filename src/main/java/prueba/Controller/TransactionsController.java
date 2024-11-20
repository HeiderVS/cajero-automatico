package prueba.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prueba.Model.Accounts;
import prueba.Model.Response;
import prueba.Model.Transactions;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/transaction")
public class TransactionsController {

    private Response response;

    @PostMapping("/nipValidation")
    public ResponseEntity<Response> nipValidation (@RequestBody Accounts account ) {
        Optional<Accounts> optionalAccount = accountService.findByAcoount_number (account.getAccount_number());
        optionalAccount.ifPresent(u -> {
            Boolean isNipValid = accountService.validNip(account.getAccount_number(), account.getAccount_nip());
            if(isNipValid){
                response = new Response(true, "cuenta validada");
                return new ResponseEntity<Response>(response, HttpStatus.OK);
            }
        });
        response = new Response(false, "transaccion fallida, cuenta o nip invalidos");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @PostMapping("/withdrawal")
    public String doWithdrawal (@RequestBody Transactions transaction) {

    }
}

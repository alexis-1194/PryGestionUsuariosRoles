package com.example.proyectogestion.service.impl;

import com.example.proyectogestion.entity.ConfirmationToken;
import com.example.proyectogestion.repository.EmailSender;
import com.example.proyectogestion.repository.UsuarioRepository;
import com.example.proyectogestion.bean.RegisterUserBean;
import com.example.proyectogestion.response.Response;
import com.example.proyectogestion.service.UsuarioService;
import com.example.proyectogestion.util.Constantes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final EmailSender emailSender;

    @Override
    public Response register(RegisterUserBean registerUserBean) {
        Response response = new Response();
        Map<String, Object> result = new HashMap<>();

        try {

            //validando si el usuario ya existe
            if(getUsuariosCount(registerUserBean.getUsuEmail())==0) {
                response.setStatusCode("9999");
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage("El usuario ya existe en la bd");
                response.setDeveloperMessage("OK");
                response.setData(null);
                response.setError(null);
                return response;
            }

            result = usuarioRepository.register(registerUserBean);
            //paso
            if (result.get("OUT_CODIGO").equals(Constantes.CODIGO_OK)) {
                ConfirmationToken confirmationToken = new ConfirmationToken();
                String token = UUID.randomUUID().toString();
                confirmationToken.setToken(token);
                confirmationToken.setUsuId((BigDecimal) result.get("OUT_USUARIO_ID"));
                confirmationToken.setConfirmedAt(null);
                confirmationToken.setTokenId(null);
                Response procesoToken = saveToken(confirmationToken);
                String link = "http://localhost:8082/clientes-backend/usuarios/confirm?token=" + token;
                RegisterUserBean userBean = (RegisterUserBean) result.get("OUT_USUARIO");
                emailSender.send(userBean.getUsuEmail(), buildEmail(userBean.getNombres(), link));
                response.setStatusCode(procesoToken.getStatusCode());
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage(procesoToken.getMessage());
                response.setDeveloperMessage("OK");
                response.setError(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatusCode(Constantes.CODIGO_ERROR);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setReason("ERROR");
            response.setMessage(result.get("OUT_MSG").toString());
            response.setDeveloperMessage(e.getMessage());
            Map<String, Object> error = new HashMap<>();
            error.put("trama", e.getStackTrace());
            response.setError(error);
        }
        return response;
    }

    @Override
    public Integer getUsuariosCount(String username) {
        return usuarioRepository.getUsuariosCount(username);
    }

    @Override
    public Response saveToken(ConfirmationToken token) {
        Response response = new Response();
        Map<String, Object> result = new HashMap<>();
        try{
            result = usuarioRepository.guardarToken(token);
            if (result.get("OUT_CODIGO").equals(Constantes.CODIGO_OK)) {
                response.setStatusCode(result.get("OUT_CODIGO").toString());
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("OK");
                response.setMessage(result.get("OUT_MSG").toString());
                response.setDeveloperMessage("OK");
                response.setError(null);
            }else{
                response.setStatusCode(result.get("OUT_CODIGO").toString());
                response.setHttpStatus(HttpStatus.OK);
                response.setReason("ERROR");
                response.setMessage(result.get("OUT_MSG").toString());
                response.setDeveloperMessage("ERROR");
                response.setError(null);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.setStatusCode(Constantes.CODIGO_ERROR);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setReason("ERROR");
            response.setMessage(result.get("OUT_MSG").toString());
            response.setDeveloperMessage(e.getMessage());
            Map<String, Object> error = new HashMap<>();
            error.put("trama", e.getStackTrace());
            response.setError(error);
        }
        return response;
    }

    private String buildEmail(String name, String link) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for registering. Please click on the below link to activate your account: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\"" + link + "\">Activate Now</a> </p></blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }

    @Override
    public Map<String,Object> getToken(String token){
        return usuarioRepository.getToken(token);
    }

    @Override
    public String confirmToken(String token) {
        Map<String,Object> map = getToken(token);
        try {
        if(map.get("OUT_CODIGO").equals(Constantes.TOKEN_CONFIRMADO)){
            return "Token already confirmed";
        }
//        else if(map.get("OUT_CODIGO").equals(Constantes.TOKEN_INVALIDO)){
//            return "Token invalid";
//        }
        else if(map.get("OUT_CODIGO").equals(Constantes.TOKEN_EXPIRADO)){
            return "Token expired";
        }
        else if(map.get("OUT_CODIGO").equals(Constantes.TOKEN_NO_ENCONTRADO)){
            return "Token not found";
        }
        else{
           //Realizar el update para el user y cambiar el token a confirmado
//            usuarioRepository.confirmToken(token);
            //actualizar el token
            ConfirmationToken confirmationToken = new ConfirmationToken();
            confirmationToken.setTokenId((BigDecimal) map.get("OUT_TOKEN_ID"));
            confirmationToken.setUsuId((BigDecimal) map.get("OUT_USU_ID"));
            Map<String,Object> enableFull = usuarioRepository.guardarToken(confirmationToken);
            if(enableFull.get("OUT_CODIGO").equals(Constantes.CODIGO_OK)){
                return "Token confirmed";
            }
            else{
                return (String) enableFull.get("OUT_MSG");
            }
        }

        }catch (Exception e){
            return "Error";
        }
    }
}

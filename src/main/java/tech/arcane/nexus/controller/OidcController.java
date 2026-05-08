package tech.arcane.nexus.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class OidcController {

    @GetMapping("/me")
    public Map<String, Object> me(@AuthenticationPrincipal OidcUser oidcUser) {
        if (oidcUser == null) {
            return Map.of("error", "Not authenticated via OIDC");
        }
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("name", oidcUser.getFullName());
        info.put("email", oidcUser.getEmail());
        info.put("picture", oidcUser.getPicture());
        info.put("claims", oidcUser.getClaims());
        return info;
    }
}

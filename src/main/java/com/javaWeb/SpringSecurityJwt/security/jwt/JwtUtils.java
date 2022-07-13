package com.javaWeb.SpringSecurityJwt.security.jwt;

import com.javaWeb.SpringSecurityJwt.security.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
* Sau khi có các thông tin về người dùng, chúng ta cần mã hóa thông tin người dùng thành chuỗi JWT.
* */
@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    // Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
    private final String jwtSecret = "khanh";

    // Thời gian có hiệu lực của chuỗi jwt
    private final long jwtExpiration = 604800000L;

    // Tạo ra thông tin từ user
    public String generateToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Date now = new Date(); // thời gian tạo
        Date expiryDate = new Date(now.getTime() + jwtExpiration); // thời gian hết hạn
        // Tạo chuỗi json web token từ userName của user.
        return Jwts.builder()
                .setSubject(userDetails.getUsername()) // cấp phát jwt cho user
                .setIssuedAt(now) // thời gian cấp
                .setExpiration(expiryDate) // thời gian hết hạn
                .signWith(SignatureAlgorithm.HS512, jwtSecret) //ký tên
                .compact(); // thực thi
    }

    // Lấy thông tin user từ jwt
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token).getBody().getSubject();
    }

    // xác thực jwt
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}

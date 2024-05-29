package com.hangileye.lifetouch.model;

import lombok.Builder;
import lombok.Data;

/*
 * 토큰
 *
보안 및 안전한 사용자 경험을 유지하기 위해서는 일반적으로 Access Token은 짧은 유효 기간을 가지고 있고, Refresh Token은 비교적 더 긴 유효 기간을 가지는 것이 좋습니다.
Access Token은 주로 실제 작업을 수행할 때 사용되며, 유효 기간이 짧을수록 보안 상 이점이 있습니다. Access Token이 탈취되더라도 해당 토큰이 유효한 기간이 짧으면 악용할 시간이 제한됩니다. 따라서 Access Token의 유효 기간을 연장하기보다는, Refresh Token의 유효 기간을 연장하는 것이 안전합니다.
Refresh Token은 Access Token을 갱신하는 데 사용되며, 일반적으로 보안상 더 민감한 정보이므로 유효 기간을 더 길게 설정하는 것이 일반적입니다. 따라서 보안 측면에서는 Refresh Token의 유효 기간을 연장하는 것이 더 바람직합니다.
요약하자면, 만료 기간을 연장할 때는 Access Token보다는 Refresh Token의 유효 기간을 연장하는 것이 보안적으로 더 좋은 선택입니다.
 *
 * */

@Data
@Builder
public class TokensModel {

    // 액세스 토큰은 OAuth 및 비슷한 인증 시스템에서 사용되는 토큰으로, 사용자가 자원에 접근할 때 사용됩니다. 주로 API 요청에서 사용되며, 유효한 액세스 토큰이 있어야 서버가 사용자의 요청을 처리할 수 있습니다. 일반적으로 액세스 토큰은 만료 기간이 있으며, 만료되면 리프레시 토큰을 사용하여 새로운 액세스 토큰을 발급받아야 합니다.
    private String accessToken;

    // 리프레시 토큰은 OAuth 및 비슷한 인증 시스템에서 사용되는 토큰입니다. 주된 역할은 인증 토큰(Access Token)이 만료되었을 때 새로운 인증 토큰을 발급받기 위한 것입니다. 사용자가 액세스 토큰을 사용하여 자원에 접근할 때마다, 리프레시 토큰은 새로운 액세스 토큰을 얻을 수 있는 권한을 제공합니다.
    private String refreshToken;

    // 등록 일자는 일반적으로 데이터베이스나 시스템에서 특정 항목이나 엔터티가 등록된 날짜를 나타냅니다. 이는 데이터를 추적하고, 분석하며, 관리하는 데 유용합니다. 예를 들어, 사용자 계정, 제품, 이벤트 등이 등록된 날짜를 기록할 수 있습니다.
    private String regDt;

    // 만료 일자는 일반적으로 시스템에서 특정 항목이나 상태가 만료되는 날짜를 나타냅니다. 이는 보안, 라이선스, 세션 등과 관련하여 사용될 수 있습니다. 만료 일자가 지나면 해당 항목이 유효하지 않게 되거나, 새로운 인증이 필요할 수 있습니다.
    private String expireDt;
}

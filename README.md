# secure-blog-api

Spring Security와 Redis 기반의 인증 및 토큰 관리를 구현한 블로그 데모 프로젝트입니다.  
JWT를 활용한 Access/Refresh Token 발급 및 갱신 로직을 포함하고 있으며,  
Redis ZSet을 사용하여 실시간 인기 검색어 랭킹 기능도 제공합니다.

### [Git] Commit Message Convension

1. Commit 메시지 구조:

   - 기본적인 커밋 메시지 구조는 다음과 같이 세 가지 파트로 나누어집니다:
     type(옵션): [#issueNumber-]Subject, body(옵션), footer(옵션).
   - 각 파트는 빈 줄로 구분됩니다.

   ```
   type(옵션): [#issueNumber-]Subject    // 제목

   body(옵션)                           // 본문

   footer(옵션)                         // 꼬리말
   ```

2. Commit Type:

   - 타입은 태그와 제목으로 구성되며, 태그는 영어로 쓰며 첫 문자는 대문자로 합니다.
   - 주요 태그:
     - feat: 새로운 기능 추가
     - fix: 버그 수정
     - docs: 문서 수정
     - style: 코드 포맷팅, 세미콜론 누락, 코드 변경 없음
     - refactor: 코드 리펙토링
     - test: 테스트 코드 추가, 리펙토링 테스트 코드 추가
     - chore: 빌드 업무 수정, 패키지 매니저 수정

3. Subject:

   - 제목은 최대 50글자가 넘지 않도록 하며, 마침표나 특수 기호는 사용하지 않습니다.
   - 영문으로 표기하고 동사(원형)를 가장 앞에 두며 첫 글자는 대문자로 표기합니다.
   - 제목은 개조식 구문으로 작성하여 간결하고 요점적인 서술을 의미합니다.

4. Body:

   - 본문은 한 줄 당 72자 내로 작성합니다.
   - 변경 내용을 상세히 작성하며, 어떻게 변경했는지보다는 무엇을 변경했는지 또는 왜 변경했는지를 설명합니다.

5. Footer:

   - 꼬리말은 optional이며 이슈 트래커 ID를 작성합니다.
   - 꼬리말 형식: "유형: #이슈 번호"
   - 여러 개의 이슈 번호를 적을 때는 쉼표(,)로 구분합니다.
   - 이슈 트래커 유형: Fixes (이슈 수정 중), Resolves (이슈 해결), Ref (참고), Related to (관련된 이슈번호)

6. Commit 예시:

   ```
   feat: [#123-]Add user registration functionality

   This commit adds the user registration feature, including SMS and email duplicate verification APIs.

   Resolves: #123
   Ref: #456
   Related to: #48, #45
   ```

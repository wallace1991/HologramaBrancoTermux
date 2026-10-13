HOLOGRAMA BRANCO — sobreposição Android decorativa

Este projeto cria uma interface flutuante decorativa. Não injeta código no Free Fire MAX, não lê a tela, não destaca inimigos e não modifica o APK do jogo.

Requisitos: Termux com Java 17+ e Gradle, além de Android SDK configurado.

1. Extraia o ZIP em ~/HologramaBranco.
2. Crie local.properties na raiz do projeto com o caminho real do SDK, por exemplo: sdk.dir=/caminho/real/android-sdk
3. Entre na pasta e execute: gradle assembleDebug
4. APK esperado: app/build/outputs/apk/debug/app-debug.apk
5. Instale, abra o app, permita “Exibir sobre outros apps” e toque em “Mostrar holograma”. Use “Fechar holograma” para encerrar.

Sem Android SDK configurado, o Gradle sozinho não consegue compilar o APK.

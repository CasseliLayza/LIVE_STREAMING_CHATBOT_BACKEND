package com.backend.boot;

import com.backend.boot.function.VoiceQueue;
import io.github.jwdeveloper.tiktok.TikTokLive;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotBackendApplication {


    public static void main(String[] args) {
        SpringApplication.run(BotBackendApplication.class, args);

        TikTokLive.newClient("@kasely_l")

/*			.onGift((liveClient, event) ->
				{
					String message = switch (event.getGift()) {
						case ROSE -> "ROSE!";
						case GG -> "GOOD GAME";
						case TIKTOK -> "Ye";
						case CORGI -> "Nice gift";
						default -> "Thank you for " + event.getGift().getName();
					};
					System.out.println(event.getUser().getProfileName() + " sends " + message);
				})*/

                .onGiftCombo((liveClient, event) ->
                {
                    System.out.println(event.getComboState() + " " + event.getCombo() + " " + event.getGift().getName());
                })
                .onRoomInfo((liveClient, event) ->
                {
                    var roomInfo = event.getRoomInfo();
                    System.out.println("Room Id: " + roomInfo.getRoomId());
                    System.out.println("Likes: " + roomInfo.getLikesCount());
                    System.out.println("Viewers: " + roomInfo.getViewersCount());
                })
                .onJoin((liveClient, event) ->
                {
                    //System.out.println(event.getUser().getProfileName() + " Hello DEVs on my stream! ");
                })
                .onConnected((liveClient, event) ->
                {
                    System.out.println("Connected to live ");
                })
                .onError((liveClient, event) ->
                {
                    System.out.println("Error! " + event.getException().getMessage());
                })
                .onComment((liveClient, event) ->
                {
                    System.out.println(event.getUser().getProfileName() + " DICE " + event.getText().toString());
                    VoiceQueue.addToQueue(event.getText());
                })
                .buildAndConnect();

    }





/*    public static void voiceBot(String texto) {

        String voz = "Microsoft David Desktop";
        int velocidad = 1;

        String command = "powershell.exe -Command \"Add-Type -AssemblyName System.Speech; " +
                "$speak = New-Object System.Speech.Synthesis.SpeechSynthesizer; " +
                "$speak.SelectVoice('" + voz + "'); " +
                "$speak.Rate = " + velocidad + "; " +
                "$speak.Speak('" + texto + "');\"";

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", command);
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    //MARY
    /*public static void voiceBot(String msj) {
        try {
            String text = "Hola, esto es una prueba de texto1 a voz en tiempo real.";
            //speak(text);
            speak(msj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void speak(String text) {
        try {
            // Crear una instancia de MaryTTS
            LocalMaryInterface marytts = new LocalMaryInterface();
            System.out.println("-------------------------------"+marytts.getAvailableVoices());

            // Seleccionar la voz (opcional, puedes ajustar a tu preferencia)
            //[, dfki-obadiah-hsmm
            // , istc-lucia-hsmm
            // , dfki-pavoque-neutral-hsmm
            // , bits1-hsmm
            // , dfki-poppy-hsmm
            // , bits3-hsmmS
            // , dfki-spike-hsmm
            // , dfki-prudence-hsmm
            // , cmu-slt-hsmm
            //marytts.setVoice("dfki-obadiah-hsmm");
            //marytts.setVoice("istc-lucia-hsmm");
            marytts.setVoice("cmu-slt-hsmm");

            // Generar flujo de audio desde el texto
            AudioInputStream audioStream = marytts.generateAudio(text);

            // Obtener el formato de audio generado
            AudioFormat audioFormat = audioStream.getFormat();

            // Configurar la línea de datos para reproducir el audio
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine dataLine = (SourceDataLine) AudioSystem.getLine(info);

            // Abrir y empezar la línea de datos
            dataLine.open(audioFormat);
            dataLine.start();

            // Leer el flujo de audio y reproducirlo en tiempo real
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = audioStream.read(buffer, 0, buffer.length)) != -1) {
                dataLine.write(buffer, 0, bytesRead);
            }

            // Cerrar el flujo de audio y la línea
            dataLine.drain();
            dataLine.close();

        } catch (MaryConfigurationException | SynthesisException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        //************************TTS++++++++++++++++++++++++++++++++++
    }*/


}

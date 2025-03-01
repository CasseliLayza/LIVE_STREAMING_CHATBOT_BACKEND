package com.backend.boot.function;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class VoiceQueue {
    private static final Queue<String> textQueue = new LinkedList<>();
    private static boolean isSpeaking = false;

    public static void addToQueue(String texto) {
        synchronized (textQueue) {
            textQueue.add(texto);
            if (!isSpeaking) {
                isSpeaking = true;
                new Thread(VoiceQueue::processQueue).start();
            }
        }
    }

    private static void processQueue() {
        while (!textQueue.isEmpty()) {
            String text;
            synchronized (textQueue) {
                text = textQueue.poll();
            }
            voiceBot(text);
        }
        isSpeaking = false;
    }

    public static void voiceBot(String texto) {
        String voz = "Microsoft David Desktop";
        int velocidad = 1;

        String command = "powershell.exe -Command \"Add-Type -AssemblyName System.Speech; " +
                "$speak = New-Object System.Speech.Synthesis.SpeechSynthesizer; " +
                "$speak.SelectVoice('" + voz + "'); " +
                "$speak.Rate = " + velocidad + "; " +
                "$speak.Speak('" + texto + "');\"";

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", command);
            pb.start().waitFor(); // wait sgt msj
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
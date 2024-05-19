package com.pingwit.part_32.daemon;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class SoundPlayerDaemonThreadExample {
    public static void main(String[] args) throws Exception {
        /*
        В Java потоки-демоны (daemon threads) - это специальный тип потоков,
        который работает в фоновом режиме и не мешает JVM завершить работу, если все остальные потоки завершили свою работу.
        Когда все обычные (не демонические) потоки завершают свою работу, JVM автоматически завершает выполнение программы, не дожидаясь завершения потоков-демонов.
         */

        Runnable soundPlayer = () -> {
            try {
                InputStream soundInputStream = ClassLoader.getSystemResourceAsStream("part_32/daemon/Imagine Dragons - Demons.WAV");
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundInputStream);

                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();

                Thread.sleep(clip.available());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread = new Thread(soundPlayer);
        thread.setDaemon(true);
        thread.start();
//        thread.join();

        System.out.println("Main thread finished");
    }
}

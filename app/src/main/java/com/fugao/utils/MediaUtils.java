package com.fugao.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;

/**
 * 多媒体应用类
 * 
 * @author raot
 * @date 2013-8-12
 */
public class MediaUtils {

	/**
	 * 图片格式
	 */
	public static String PHOTO = ".jpg";
	/**
	 * 音频格式
	 */
	public static String AUDIO = ".mp3";
	/**
	 * 视频格式
	 */
	public static String VIDEO = ".3gp";

	/**
	 * 使用照相机
	 * 
	 * @param activity
	 * @param requestCode
	 *            请求代码
	 */
	public static void startCamera(Activity activity, int requestCode) {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		activity.startActivityForResult(intent, requestCode);
	}

	public static Uri getUri(String photoPath, String photoName) {
		Uri photoUri = null;
		String path = "";
		FileHelper.creatSDDir(photoPath);
		if (!StringUtils.StringIsEmpty(photoName)) {
			if (StringUtils.StringIsEmpty(photoPath)) {
				path = photoName;
			} else {
				path = photoPath + "/" + photoName;
			}
			try {
				File photoFile = new File(FileHelper.appSDPath + "/" + path);
				if (!photoFile.exists()) {
					photoFile.createNewFile();
				}
				photoUri = Uri.fromFile(photoFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return photoUri;
	}

	public static void startCameraToCutPicture(Activity activity,
			String photoPath, String photoName, int requestCode) {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		Uri photoUri = getUri(photoPath, photoName);
		if (photoUri != null) {
			intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
			activity.startActivityForResult(intent, requestCode);
		}
	}

	/**
	 * 处理照片(保存base64格式)
	 * 
	 * @param photoPath
	 *            照片所处的文件夹(不包含根文件夹路径)
	 * @param photoName
	 *            照片名称
	 * @param intent
	 *            照相机处返回的intent
	 * @return 图片的base64字符串
	 */
	public static String cameraResultToBase64(String photoPath,
			String photoName, Intent intent) {
		String content = "";
		if (intent != null) {
			Uri uri = intent.getData();
			Bitmap resultPhoto = null;
			if (uri != null) {
				resultPhoto = BitmapFactory.decodeFile(uri.getPath());
			}
			if (resultPhoto == null) {
				Bundle bundle = intent.getExtras();
				if (bundle != null) {
					resultPhoto = (Bitmap) bundle.get("data");
					// 不剪切，以base64字符串存入本地
					content = ImageUtils.bitmapToBase64(resultPhoto);
				}
			}
		}
		return content;
	}

	/**
	 * 处理照片(保存jpg格式)
	 * 
	 * @param photoPath
	 *            照片所处的文件夹(不包含根文件夹路径)
	 * @param photoName
	 *            照片名称
	 * @param intent
	 *            照相机处返回的intent
	 * @return 图片路径(不包含根文件夹路径)
	 */
	public static String cameraResult(String photoPath, String photoName,
			Intent intent) {
		String picturePath = "";
		if (intent != null) {
			Uri uri = intent.getData();
			Bitmap resultPhoto = null;
			if (uri != null) {
				resultPhoto = BitmapFactory.decodeFile(uri.getPath());
			}
			if (resultPhoto == null) {
				Bundle bundle = intent.getExtras();
				if (bundle != null) {
					resultPhoto = (Bitmap) bundle.get("data");
					picturePath = FileHelper.saveBitmap(photoPath, photoName,
							resultPhoto);
				}
			}
		}
		return picturePath;
	}

	/**
	 * 获取图片进行剪切
	 * 
	 * @param activity
	 * @param requestCode
	 *            请求代码
	 * @param picturePath
	 *            图片所处的文件夹路径(不包含根文件夹路径)
	 * @param pictureName
	 *            图片名称
	 */
	public static void startCutPicture(Activity activity, int requestCode,
			String picturePath, String pictureName) {
		Uri pictureUri = getUri(picturePath, pictureName);
		if (pictureUri != null && !StringUtils.StringIsEmpty(pictureName)) {
			Intent intent = new Intent("com.android.camera.action.CROP");
			// 需要裁减的图片格式
			intent.setDataAndType(pictureUri, "image/*");
			// 允许裁减
			intent.putExtra("crop", "true");
			// 剪裁后ImageView显时图片的宽
			intent.putExtra("outputX", 250);
			// 剪裁后ImageView显时图片的高
			intent.putExtra("outputY", 250);
			// 设置剪裁框的宽高比例
			intent.putExtra("aspectX", 1);
			intent.putExtra("aspectY", 1);
			intent.putExtra("return-data", true);
			activity.startActivityForResult(intent, requestCode);
		}
	}

	/**
	 * 剪切图片结果处理
	 * 
	 * @param picturePath
	 *            图片所处的文件夹路径(不包含根文件夹路径)
	 * @param pictureName
	 *            图片名称
	 * @param intent
	 * @return 图片的base64字符串
	 */
	public static String cutPictureResult(String picturePath,
			String pictureName, Intent intent) {
		String content = "";
		Bitmap resultPicture = null;
		String path = "";
		if (StringUtils.StringIsEmpty(picturePath)) {
			path = pictureName;
		} else {
			path = picturePath + "/" + pictureName;
		}
		FileHelper.deleteFile(path);
		if (intent != null) {
			Bundle extras = intent.getExtras();
			if (extras != null) {
				resultPicture = extras.getParcelable("data");
				content = ImageUtils.bitmapToBase64(resultPicture);
			}
		}
		return content;
	}

	/**
	 * 启动视频录制
	 * 
	 * @param activity
	 * @param requestCode
	 *            请求代码
	 * @param videoPath
	 *            视频所处的文件夹路径(不包含根文件夹路径)
	 * @param videoName
	 *            视频名称
	 */
	public static void startVideo(Activity activity, int requestCode) {
		Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0.5);// 画质0.5
		intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 70000);// 70s
		activity.startActivityForResult(intent, requestCode);// CAMERA_ACTIVITY
																// = 1
	}

	/**
	 * 保存录制的视频
	 * 
	 * @param videoPath
	 *            视频所处的路径(不包含根文件夹路径)
	 * @param videoName
	 *            视频名称
	 * @param intent
	 * @return 视频路径
	 */
	public static String videoResult(Activity activity, String videoPath,
			String videoName, Intent intent) {
		String path = "";
		AssetFileDescriptor assetFileDescriptor;
		if (intent != null) {
			try {
				Uri uri = intent.getData();
				if (uri != null) {
					assetFileDescriptor = activity.getContentResolver()
							.openAssetFileDescriptor(intent.getData(), "r");
					FileInputStream fileInputStream = assetFileDescriptor
							.createInputStream();
					if (!StringUtils.StringIsEmpty(videoPath)) {
						FileHelper.creatSDDir(videoPath);
					}
					File file = new File(
							FileHelper.appSDPath + "/" + videoPath, videoName);
					FileOutputStream fileOutputStream = new FileOutputStream(
							file);
					byte[] buf = new byte[1024];
					int len;
					while ((len = fileInputStream.read(buf)) > 0) {
						fileOutputStream.write(buf, 0, len);
					}
					fileInputStream.close();
					fileOutputStream.flush();
					fileOutputStream.close();
					path = file.getAbsolutePath();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return path;
	}

	/**
	 * 录音
	 * 
	 * @param mediaRecorder
	 * @param recordingPath
	 *            录音所处的路径(不包含根文件夹路径)
	 * @param recordingName
	 *            录音名称
	 * @return
	 */
	public static MediaRecorder startRecording(MediaRecorder mediaRecorder,
			String recordingPath, String recordingName) {
		try {
			if (!StringUtils.StringIsEmpty(recordingPath)) {
				FileHelper.creatSDDir(recordingPath);
			}
			File file = new File(FileHelper.appSDPath + "/" + recordingPath,
					recordingName);
			String path = file.getAbsolutePath();
			mediaRecorder = new MediaRecorder();
			mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
			mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
			mediaRecorder.setOutputFile(path);
			mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
			mediaRecorder.prepare();
			mediaRecorder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mediaRecorder;
	}

	/**
	 * 停止录音
	 * 
	 * @param mediaRecorder
	 * @return
	 */
	public static MediaRecorder stopRecording(MediaRecorder mediaRecorder) {
		if (mediaRecorder != null) {
			mediaRecorder.stop();
			mediaRecorder.release();
			mediaRecorder = null;
		}
		return mediaRecorder;
	}

	/**
	 * 播放sdcard中的音频文件
	 * 
	 * @param audioPath
	 * @param activity
	 */
	public static void startPlayingAudioBySDcard(String audioPath,
			Activity activity) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.parse(audioPath), "audio/*");
		intent.setComponent(new ComponentName("com.android.music",
				"com.android.music.MediaPlaybackActivity"));
		activity.startActivity(intent);
	}

	/**
	 * 播放sdcard中的视频文件
	 * 
	 * @param videoPath
	 * @param activity
	 */
	public static void startPlayingVideoBySDcard(String videoPath,
			Activity activity) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.parse(videoPath), "video/*");
		activity.startActivity(intent);
	}

	/**
	 * 播放网络中的多媒体文件
	 * 
	 * @param mediaUrl
	 * @param activity
	 */
	public static void startPlayingMediaByInternet(String mediaUrl,
			Activity activity) {
		String extension = MimeTypeMap.getFileExtensionFromUrl(mediaUrl);
		String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
				extension);
		Intent mediaIntent = new Intent(Intent.ACTION_VIEW);
		mediaIntent.setDataAndType(Uri.parse(mediaUrl), mimeType);
		activity.startActivity(mediaIntent);
	}

	/**
	 * 播放录音
	 * 
	 * @param mediaPlayer
	 * @param recordingPath
	 *            录音所处的路径
	 * @return
	 */
	public static MediaPlayer startPlaying(MediaPlayer mediaPlayer,
			String recordingPath) {
		try {
			File file = new File(recordingPath);
			if (file.exists()) {
				String path = file.getAbsolutePath();
				mediaPlayer = new MediaPlayer();
				mediaPlayer.setDataSource(path);
				mediaPlayer.prepare();
				mediaPlayer.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mediaPlayer;
	}

	/**
	 * 播放录音(从网络中获取)
	 * 
	 * @param mediaPlayer
	 * @param recordingPath
	 *            录音所处的路径
	 * @return
	 */
	public static MediaPlayer startPlayingByUpdate(MediaPlayer mediaPlayer,
			String recordingPath) {
		try {
			mediaPlayer = new MediaPlayer();
			mediaPlayer.setDataSource(recordingPath);
			mediaPlayer.prepare();
			mediaPlayer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mediaPlayer;
	}

	/**
	 * 停止播放录音
	 * 
	 * @param mediaPlayer
	 * @return
	 */
	public static MediaPlayer stopPlaying(MediaPlayer mediaPlayer) {
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
		}
		return mediaPlayer;
	}
}

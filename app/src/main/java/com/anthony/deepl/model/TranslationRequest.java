package com.anthony.deepl.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TranslationRequest {

    @SerializedName("jsonrpc")
    private String mJsonRpc = "2.0";

    @SerializedName("method")
    private String mMethod = "LMT_handle_jobs";

    @SerializedName("params")
    private TranslationRequestParams mParams;

    public TranslationRequest(String sentence, String fromLanguage, String toLanguage, List<String> userPreferredLanguages) {
        TranslationRequestJob job = new TranslationRequestJob();
        job.setSentence(sentence);
        List<TranslationRequestJob> jobList = new ArrayList<>();
        jobList.add(job);

        TranslationRequestLanguage languages = new TranslationRequestLanguage();
        languages.setSourceLanguage(fromLanguage);
        languages.setTargetLanguage(toLanguage);
        languages.setPreferredLanguages(userPreferredLanguages);

        mParams = new TranslationRequestParams();
        mParams.setJobList(jobList);
        mParams.setRequestLanguages(languages);
    }

}

class TranslationRequestParams {

    @SerializedName("priority")
    private short mPriority = -1;

    @SerializedName("jobs")
    private List<TranslationRequestJob> mJobs;

    @SerializedName("lang")
    private TranslationRequestLanguage mLanguages;

    void setJobList(List<TranslationRequestJob> jobs) {
        mJobs = jobs;
    }

    void setRequestLanguages(TranslationRequestLanguage languages) {
        mLanguages = languages;
    }

}

class TranslationRequestJob {

    @SerializedName("kind")
    private String mJobKind = "default";

    @SerializedName("raw_en_sentence")
    private String mSentence = "LMT_handle_jobs";

    void setSentence(String sentence) {
        mSentence = sentence;
    }

}

class TranslationRequestLanguage {

    @SerializedName("source_lang_user_selected")
    private String mSourceLanguage;

    @SerializedName("target_lang")
    private String mTargetLanguage;

    @SerializedName("user_preferred_langs")
    private List<String> mPreferredLanguages;

    void setSourceLanguage(String sourceLanguage) {
        mSourceLanguage = sourceLanguage;
    }

    void setTargetLanguage(String targetLanguage) {
        mTargetLanguage = targetLanguage;
    }

    void setPreferredLanguages(List<String> preferredLanguages) {
        mPreferredLanguages = preferredLanguages;
    }

}
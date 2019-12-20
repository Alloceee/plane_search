package com.yws.plane.service.home;

import com.yws.plane.entity.Email;

public interface MailService {
    /**
     * 纯文本
     * @Author  科帮网
     * @param mail
     * @throws Exception  void
     * @Date	2017年7月20日
     * 更新日志
     * 2017年7月20日  科帮网 首次创建
     */
    String send(Email mail);

    /**
     * 携带附件
     */
    void sendAttachmentsMail(Email email, String filePath);
    /**
     * 富文本
     * @Author  科帮网
     * @param mail
     * @throws Exception  void
     * @Date	2017年7月20日
     * 更新日志
     * 2017年7月20日  科帮网 首次创建
     *
     */
    void sendHtml(Email mail) throws Exception;
    /**
     * 模版发送 thymeleaf(弃用、需要配合模板)
     * @Author  科帮网
     * @param mail
     * @throws Exception  void
     * @Date	2017年7月20日
     * 更新日志
     * 2017年7月20日  科帮网 首次创建
     *
     */
    void sendThymeleaf(Email mail) throws Exception;
    /**
     * 队列
     * @Author  科帮网
     * @param mail
     * @throws Exception  void
     * @Date	2017年8月4日
     * 更新日志
     * 2017年8月4日  科帮网 首次创建
     *
     */
    void sendQueue(Email mail) throws Exception;
    /**
     * Redis 队列
     * @Author  科帮网
     * @param mail
     * @throws Exception  void
     * @Date	2017年8月13日
     * 更新日志
     * 2017年8月13日  科帮网 首次创建
     *
     */
    void sendRedisQueue(Email mail) throws Exception;


//    Result listMail(Email mail);
}

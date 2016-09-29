/**
 * like-dislike v1.0.2
 *
 * jQuery rating plugin, https://github.com/uagrace/like-dislike
 *
 * Copyright 2016, Maxim Tkachuk, mxtkachuk@gmail.com
 *
 * Licensed under the MIT license
 */
(function ($) {

    var likeBtn = 'like';
    var dislikeBtn = 'dislike';

    var methods = {
        init: function (options) {
            this.opts = $.extend(true, {}, $.fn.likeDislike.defaults, options);
            var opts = this.opts;

            this.btns = $(this).find('.' + opts.likeBtnClass + ', .' + opts.dislikeBtnClass);

            this.readOnly = methods.readOnly;
            this.readOnly(opts.readOnly);

            if (opts.initialValue !== 0) {
                var activeBtn = opts.initialValue === 1 ? likeBtn : dislikeBtn;
                methods._btnDown.call(this, activeBtn);
            }

            return this;
        },
        readOnly: function (state) {
            var opts = this.opts;
            var btns = this.btns;

            if (!state) {
                if (!opts.reverseMode) {
                    var notActiveBtns = btns.not('.' + opts.activeClass);
                    if (notActiveBtns.length) {
                        btns = notActiveBtns;
                    }
                }
                methods._on.call(this, btns);
            } else {
                methods._off.call(this, btns);
            }
        },
        _btnDown: function (btnType) {
            var btn = methods._getBtnByType.call(this, btnType);
            btn.addClass(this.opts.activeClass);

            if (!this.opts.reverseMode) {
                methods._off.call(this, btn);
            }
        },
        _btnUp: function (btnType) {
            var btn = methods._getBtnByType.call(this, btnType);

            if (!this.opts.reverseMode) {
                methods._on.call(this, btn);
            }

            btn.removeClass(this.opts.activeClass);
        },
        _getBtnByType: function (btnType) {
            if (btnType === likeBtn) {
                return $(this).find('.' + this.opts.likeBtnClass);
            } else if (btnType === dislikeBtn) {
                return $(this).find('.' + this.opts.dislikeBtnClass);
            } else {
                $.error('Wrong button type: ' + btnType);
            }
        },
        _on: function (btn) {
            var self = this;
            var opts = self.opts;

            btn.removeClass(opts.disabledClass);

            if (opts.beforeClick) {
                btn.on('beforeClick', function (event) {
                    return opts.beforeClick.call(self, event);
                });
            }

            btn.on('click', function (event) {
                var btn = $(this);

                if (opts.beforeClick && !btn.triggerHandler('beforeClick')) {
                    return false;
                }

                var btnType = btn.hasClass(opts.likeBtnClass) ? likeBtn : dislikeBtn;
                var hasActive = self.btns.hasClass(opts.activeClass);
                var isActive = btn.hasClass(opts.activeClass);

                var value = 0;

                if (opts.reverseMode) {
                    if (btnType === likeBtn) {
                        if (isActive) {
                            methods._btnUp.call(self, likeBtn);
                        } else {
                            methods._btnUp.call(self, dislikeBtn);
                            methods._btnDown.call(self, likeBtn);
                            value = 1;
                        }
                    } else {
                        if (isActive) {
                            methods._btnUp.call(self, dislikeBtn);
                        } else {
                            methods._btnUp.call(self, likeBtn);
                            methods._btnDown.call(self, dislikeBtn);
                            value = -1;
                        }
                    }
                } else {
                    if (btnType === likeBtn) {
                        if (hasActive) {
                            methods._btnUp.call(self, dislikeBtn);
                            methods._btnDown.call(self, likeBtn);
                            if (!isActive) {
                                value = 1;
                            }
                        } else {
                            methods._btnDown.call(self, likeBtn);
                            value = 1;
                        }
                    } else {
                        if (hasActive) {
                            methods._btnUp.call(self, likeBtn);
                            methods._btnDown.call(self, dislikeBtn);
                            if (!isActive) {
                                value = -1;
                            }
                        } else {
                            methods._btnDown.call(self, dislikeBtn);
                            value = -1;
                        }
                    }
                }

                opts.click.call(self, value, btnType, event);

            });
        },
        _off: function (btn) {
            btn.addClass(this.opts.disabledClass);
            btn.off();
        }
    };

    $.fn.likeDislike = function (method) {
        if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || !method) {
            return methods.init.apply(this, arguments);
        } else {
            $.error('Method ' + method + ' does not exist!');
        }
    };

    $.fn.likeDislike.defaults = {
        click: null,
        beforeClick: null,
        initialValue: 0,
        readOnly: false,
        reverseMode: true,
        likeBtnClass: 'like',
        dislikeBtnClass: 'dislike',
        activeClass: 'active',
        disabledClass: 'disabled'
    };

})(jQuery);
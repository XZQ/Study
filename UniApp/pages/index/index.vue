<template>
	<view>
		<pubTitle sub-title="LLJ"></pubTitle>
		<myevent @myEnv="myEnv"></myevent>
		<swiper class="swiper" circular="true" autoplay="true" ininterval="2000" duration="200" indicator-dots="true"
			indicator-active-color="pink" indicator-color="green">
			<swiper-item class="item">
				<image src="../../static/list/pic1.jpg" mode="aspectFill"></image>
			</swiper-item>
			<swiper-item class="item">
				<image src="../../static/list/pic2.jpg" mode="aspectFill"></image>
			</swiper-item>
			<swiper-item class="item">
				<image src="../../static/list/pic3.jpg" mode="aspectFill"></image>
			</swiper-item>
			<swiper-item class="item">
				<image src="../../static/list/pic4.jpg" mode="aspectFill"></image>
			</swiper-item>
		</swiper>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello'
			}
		},
		onLoad() {

		},
		methods: {
			myEnv(e) {
				console.log("我被打印了 " + e);
			}
		}
	}
</script>

<style lang="scss">
	.swiper {
		width: 100%;
		height: 400rpx;
		margin-top: 10rpx;

		.item {
			image {
				width: 100%;
				height: 400rpx;
			}
		}
	}

	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 300rpx;
		width: 300rpx;
		margin-top: 300rpx;
		margin-left: auto;
		margin-right: auto;
	}

	.text-area {
		display: flex;
		justify-content: space-around;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}

	.out {
		width: 100%;

		.block {
			width: 750rpx;
			height: 200rpx;
			background: palegreen;
		}
	}
</style>
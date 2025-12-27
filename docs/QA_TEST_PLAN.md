# QA Test Plan: Enhanced Lava

Generated: 2025-12-27T17:25:59.126Z
Minecraft Version: 1.21.1
Mod ID: enhancedlava

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 63 |
| Passed | 56 |
| Failed | 0 |
| Warnings | 4 |
| Skipped | 3 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `enhancedlava.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Raw Lava Shard | `/give @p enhancedlava:raw_lava_shard` | ☐ | ☐ | ☐ |
| Lava Crystal | `/give @p enhancedlava:lava_crystal` | ☐ | ☐ | ☐ |
| Ignited Lava Shard | `/give @p enhancedlava:ignited_lava_shard` | ☐ | ☐ | ☐ |
| Volcanic Pickaxe | `/give @p enhancedlava:volcanic_pickaxe` | ☐ | ☐ | ☐ |
| Volcanic Sword | `/give @p enhancedlava:volcanic_sword` | ☐ | ☐ | ☐ |
| Lava Infused Apple | `/give @p enhancedlava:lava_infused_apple` | ☐ | ☐ | ☐ |
| Crystal Shard | `/give @p enhancedlava:crystal_shard` | ☐ | ☐ | ☐ |

### Item Tests

#### Raw Lava Shard

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Raw Lava Shard"
- [ ] Crafting recipe works

#### Lava Crystal

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lava Crystal"
- [ ] Crafting recipe works

#### Ignited Lava Shard

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Ignited Lava Shard"
- [ ] Crafting recipe works

#### Volcanic Pickaxe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Volcanic Pickaxe"
- [ ] Crafting recipe works
- [ ] Right-click action works: projectile
- [ ] Cooldown applies (20 ticks)
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Volcanic Sword

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Volcanic Sword"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Lava Infused Apple

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lava Infused Apple"
- [ ] Crafting recipe works

#### Crystal Shard

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Crystal Shard"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Volcanic Core | `/give @p enhancedlava:volcanic_core` | ☐ | ☐ | ☐ |
| Hardened Lava Block | `/give @p enhancedlava:hardened_lava_block` | ☐ | ☐ | ☐ |
| Lava Crystal Ore | `/give @p enhancedlava:lava_crystal_ore` | ☐ | ☐ | ☐ |
| Enhanced Lava | `/give @p enhancedlava:lava_block` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable

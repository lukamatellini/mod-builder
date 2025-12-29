# QA Test Plan: Lucky Blocks

Generated: 2025-12-29T03:29:30.904Z
Minecraft Version: 1.21.1
Mod ID: luckyblocks

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 30 |
| Passed | 26 |
| Failed | 0 |
| Warnings | 2 |
| Skipped | 2 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `luckyblocks.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Minecraftair | `/give @p luckyblocks:minecraftair` | ☐ | ☐ | ☐ |
| Living Wood | `/give @p luckyblocks:living_wood` | ☐ | ☐ | ☐ |

### Item Tests

#### Minecraftair

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Minecraftair"
- [ ] Crafting recipe works

#### Living Wood

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Living Wood"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p luckyblocks:lucky_block` | ☐ | ☐ | ☐ |

## Structures Checklist

### Small Stone Building
- [ ] Structure generates in world
- [ ] Use `/locate structure luckyblocks:small_stone_building` to find
- [ ] Contains expected features

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
